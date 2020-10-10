package microreso.system.db

import microreso.domain.organisation.OrganisationRepository
import microreso.domain.organisation.model.Organisation
import scalikejdbc._

import scala.concurrent.{ExecutionContext, Future}

class OrganisationRepositoryPostgres()(
  implicit
  session: DBSession,
  ec: ExecutionContext
) extends OrganisationRepository {

  import OrganisationRepositoryPostgres._

  override def isInitialized(): Future[Boolean] = {
    get().map(_.isDefined)
  }

  private def get(): Future[Option[OrganisationTable]] = Future {
    withSQL {
      select
        .from(OrganisationTable as o)
        .offset(0)
        .limit(1)
    }
      .map(OrganisationTable.apply(o))
      .single()
      .apply()
  }

  override def initialize(organisation: Organisation): Future[Organisation] = {
    insert(organisation)
      .map(_ => organisation)
  }

  private def insert(organisation: Organisation): Future[Int] = Future {
    withSQL {
      insertInto(OrganisationTable)
        .namedValues(
          c.code -> organisation.code.value,
          c.name -> organisation.name
        )
    }
      .update()
      .apply()
  }
}

object OrganisationRepositoryPostgres {

  private val o = OrganisationTable.syntax("o")
  private val c = OrganisationTable.column

  case class OrganisationTable(
    code: String,
    name: String
  )

  object OrganisationTable extends SQLSyntaxSupport[OrganisationTable] {
    override val tableName = "organisation"

    def apply(p: SyntaxProvider[OrganisationTable])(rs: WrappedResultSet): OrganisationTable = apply(p.resultName)(rs)
    def apply(p: ResultName[OrganisationTable])(rs: WrappedResultSet): OrganisationTable = {
      OrganisationTable(
        code = rs.get[String](p.code),
        name = rs.get[String](p.name)
      )
    }
  }

}