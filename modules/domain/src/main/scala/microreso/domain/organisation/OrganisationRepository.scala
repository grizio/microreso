package microreso.domain.organisation

import microreso.domain.organisation.model.Organisation

import scala.concurrent.Future

trait OrganisationRepository {
  def isInitialized(): Future[Boolean]

  def initialize(organisation: Organisation): Future[Organisation]
}
