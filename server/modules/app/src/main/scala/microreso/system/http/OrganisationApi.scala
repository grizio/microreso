package microreso.system.http

import microreso.domain.organisation.Initializer.{AlreadyInitialized, Initialized}
import microreso.domain.organisation.model.OrganisationCode
import microreso.system.db.DatabaseTransaction
import microreso.system.http.api.definitions.{Error, Initialize, Organisation}
import microreso.system.http.api.organisation.{OrganisationHandler, OrganisationResource}
import microreso.system.organisation.InitializerFactory

import scala.concurrent.{ExecutionContext, Future}

class OrganisationApi(
  databaseTransaction: DatabaseTransaction,
  initializerFactory: InitializerFactory
)(
  implicit ec: ExecutionContext
) extends OrganisationHandler {
  override def createOrganisation(respond: OrganisationResource.CreateOrganisationResponse.type)(body: Initialize): Future[OrganisationResource.CreateOrganisationResponse] = {
    databaseTransaction.withTransaction { implicit session =>
      initializerFactory.create().initialize(convertInitializeToDomain(body))
    }
      .map {
        case Initialized(organisation) =>
          respond.OK(convertOrganisationFromDomain(organisation))
        case AlreadyInitialized =>
          respond.BadRequest(
            Error(
              code = "organisation.alreadyInitialized",
              message = "The organisation is already initialized"
            )
          )
      }
  }

  private def convertInitializeToDomain(initialize: Initialize): microreso.domain.organisation.Initializer.Initialize = {
    microreso.domain.organisation.Initializer.Initialize(
      code = OrganisationCode(initialize.code),
      name = initialize.name
    )
  }

  private def convertOrganisationFromDomain(organisation: microreso.domain.organisation.model.Organisation): Organisation = {
    Organisation(
      code = organisation.code.value,
      name = organisation.name
    )
  }
}
