package microreso.system.http

import akka.http.scaladsl.server.Route
import akka.stream.Materializer
import microreso.system.db.DatabaseTransaction
import microreso.system.http.api.organisation.OrganisationResource
import microreso.system.organisation.InitializerFactory

import scala.concurrent.ExecutionContext

class Router(
  databaseTransaction: DatabaseTransaction,
  initializerFactory: InitializerFactory
)(
  implicit
  ec: ExecutionContext,
  mat: Materializer
) {
  def route: Route = organisationRoute

  private def organisationRoute: Route = OrganisationResource.routes(new OrganisationApi(databaseTransaction, initializerFactory))
}
