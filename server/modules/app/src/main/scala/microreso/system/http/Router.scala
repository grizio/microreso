package microreso.system.http

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import akka.stream.Materializer
import microreso.system.db.DatabaseTransaction
import microreso.system.http.api.organisation.OrganisationResource
import microreso.system.organisation.InitializerFactory

import scala.concurrent.ExecutionContext

class Router(
  databaseTransaction: DatabaseTransaction,
  initializerFactory: InitializerFactory,
  webRouter: WebRouter
)(
  implicit
  ec: ExecutionContext,
  mat: Materializer
) {
  def route: Route = organisationRoute ~ webRouter.route

  private def organisationRoute: Route = OrganisationResource.routes(new OrganisationApi(databaseTransaction, initializerFactory))
}
