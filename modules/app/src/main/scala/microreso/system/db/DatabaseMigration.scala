package microreso.system.db

import org.flywaydb.core.Flyway

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try

class DatabaseMigration(config: DatabaseConfiguration)(implicit ec: ExecutionContext) {
  def migrate(): Future[Unit] = Future.fromTry {
    Try {
      println("plop")
      val flyway = Flyway.configure
        .dataSource(config.connectionURL, config.username, config.password)
        .load

      println("migrate")
      flyway.migrate()
    }
  }
}
