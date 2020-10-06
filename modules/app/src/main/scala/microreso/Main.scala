package microreso

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import microreso.system.db.{DatabaseMigration, DatabaseTransaction}
import microreso.system.http.Router
import microreso.system.organisation.InitializerFactory

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.io.StdIn
import scala.util.{Failure, Success}

object Main extends App {
  implicit val system: ActorSystem = ActorSystem("my-system")
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  val config = new AppConfiguration()

  val databaseMigration = new DatabaseMigration(config.database)
  val databaseTransaction = new DatabaseTransaction(config.database)

  val initializerFactory = new InitializerFactory()

  val router = new Router(databaseTransaction, initializerFactory)


  val bindingFuture = for {
    _ <- databaseMigration.migrate()
    binding <- Http().newServerAt(config.http.host, config.http.port).bind(router.route)
    _ = println(s"Server online at http://${config.http.host}:${config.http.port}/\nPress RETURN to stop...")
    _ = Future(StdIn.readLine())
    _ <- binding.unbind()
  } yield {
    binding
  }

  bindingFuture
    .andThen {
      case Success(_) => println("Shutting down")
      case Failure(exception) =>
        println("An error happened")
        println(exception)
        exception.printStackTrace()
        println("Shutting down")
    }
    .onComplete { _ =>
      system.terminate()
    }
}
