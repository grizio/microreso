package microreso.system.http

import microreso.domain.initialize.Initializer
import microreso.domain.initialize.Initializer.{AlreadyInitialized, Initialized}
import microreso.domain.organisation.model.OrganisationCode
import microreso.system.db.DatabaseTransaction
import microreso.system.http.api.application.{ApplicationHandler, ApplicationResource}
import microreso.system.http.api.definitions.{Error, Initialize}
import microreso.system.organisation.InitializerFactory

import scala.concurrent.{ExecutionContext, Future}

class ApplicationApi(
  databaseTransaction: DatabaseTransaction,
  initializerFactory: InitializerFactory
)(
  implicit ec: ExecutionContext
) extends ApplicationHandler {
  override def initialize(respond: ApplicationResource.InitializeResponse.type)(body: Initialize): Future[ApplicationResource.InitializeResponse] = {
    databaseTransaction.withTransaction { implicit session =>
      initializerFactory.create().initialize(convertInitializeToDomain(body))
    }
      .map {
        case Initialized =>
          respond.OK
        case AlreadyInitialized =>
          respond.BadRequest(
            Error(
              code = "organisation.alreadyInitialized",
              message = "The organisation is already initialized"
            )
          )
      }
  }

  private def convertInitializeToDomain(initialize: Initialize): Initializer.Initialize = {
    Initializer.Initialize(
      code = OrganisationCode(initialize.code),
      name = initialize.name,
      admin = Initializer.Admin(
        username = initialize.admin.username,
        rawPassword = initialize.admin.password,
        email = initialize.admin.email
      )
    )
  }
}
