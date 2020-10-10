package microreso.system.http

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import microreso.system.db.DatabaseTransaction
import microreso.system.organisation.InitializerFactory
import microreso.system.http.model._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.model.{ContentType, ContentTypes, HttpCharsets, HttpEntity, HttpResponse, MediaType, MediaTypes, StatusCodes}
import microreso.domain.organisation.Initializer.{AlreadyInitialized, Initialized}
import microreso.macros.Json
import spray.json.enrichAny

import scala.concurrent.ExecutionContext

class Router(
  databaseTransaction: DatabaseTransaction,
  initializerFactory: InitializerFactory
)(
  implicit ec: ExecutionContext
) {

  def route: Route = {
    (post & path("organisation") & entity(as[Initialize])) { initialize =>
      complete {
        databaseTransaction.withConnection { implicit session =>
          initializerFactory.create().initialize(initialize.toDomain)
        }
          .map {
            case Initialized(organisation) =>
              HttpResponse(
                status = StatusCodes.OK,
                entity = HttpEntity(
                  contentType = ContentTypes.`application/json`,
                  Organisation.format.write(Organisation.fromDomain(organisation)).toString()
                )
              )
            case AlreadyInitialized =>
              HttpResponse(
                status = StatusCodes.BadRequest,
                entity = "The organisation is already initialized"
              )
          }
      }
    } ~ (post & path("users")) {
      complete("TODO")
    }
  }
}
