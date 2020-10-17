package microreso.system.http

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import microreso.system.db.DatabaseTransaction
import microreso.system.organisation.InitializerFactory

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Success

class WebRouter(
  databaseTransaction: DatabaseTransaction,
  initializerFactory: InitializerFactory
)(implicit ec: ExecutionContext) {
  private var initialized: Boolean = false

  def route: Route = {
    // dummy action to force compute of getInitialized()
    extractActorSystem { _ =>
      onSuccess(getInitialized()) { isInitialized =>
        if (isInitialized) {
          pathEndOrSingleSlash {
            getFromResource("web/main/index.html")
          } ~ {
            getFromResourceDirectory("web/main")
          }
        } else {
          pathEndOrSingleSlash {
            getFromResource("web/initialize/index.html")
          } ~ {
            getFromResourceDirectory("web/initialize")
          }
        }
      }
    }
  }

  private def getInitialized(): Future[Boolean] = {
    if (initialized) {
      Future.successful(true)
    } else {
      databaseTransaction.withTransaction { implicit session =>
        initializerFactory.create().checkInitialization()
      }
        .andThen {
          case Success(true) => initialized = true
        }
    }
  }
}
