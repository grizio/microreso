package microreso.system.organisation

import microreso.domain.initialize.Initializer
import microreso.system.db.{OrganisationRepositoryPostgres, UserRepositoryPostgres}
import scalikejdbc.DBSession

import scala.concurrent.ExecutionContext

class InitializerFactory()(implicit ec: ExecutionContext) {
  def create()(implicit session: DBSession): Initializer = {
    new Initializer(
      organisationRepository = new OrganisationRepositoryPostgres(),
      userRepository = new UserRepositoryPostgres()
    )
  }
}
