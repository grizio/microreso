package microreso.system.organisation

import microreso.domain.organisation.Initializer
import microreso.system.db.OrganisationRepositoryPostgres
import scalikejdbc.DBSession

import scala.concurrent.ExecutionContext

class InitializerFactory()(implicit ec: ExecutionContext) {
  def create()(implicit session: DBSession): Initializer = {
    new Initializer(
      organisationRepository = new OrganisationRepositoryPostgres()
    )
  }
}
