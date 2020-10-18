package microreso.system.db

import java.util.UUID

import microreso.domain.user.UserRepository
import microreso.domain.user.model.{User, UserRole}
import scalikejdbc._

import scala.concurrent.{ExecutionContext, Future}
import DatabaseBinders._

class UserRepositoryPostgres()(
  implicit
  session: DBSession,
  ec: ExecutionContext
) extends UserRepository {
  import UserRepositoryPostgres._

  override def insert(user: User): Future[User] = Future {
    withSQL {
      insertInto(UserTable)
        .namedValues(
          c.id -> user.id.value,
          c.username -> user.username.value,
          c.password -> user.password,
          c.email -> user.email,
          c.role -> user.role
        )
    }
      .update()
      .apply()
  }.map(_ => user)
}

object UserRepositoryPostgres {
  private val u = UserTable.syntax("u")
  private val c = UserTable.column

  case class UserTable(
    id: UUID,
    username: String,
    password: String,
    email: String,
    role: UserRole.Value
  )

  object UserTable extends SQLSyntaxSupport[UserTable] {
    override val tableName = "users"

    def apply(p: SyntaxProvider[UserTable])(rs: WrappedResultSet): UserTable = apply(p.resultName)(rs)
    def apply(p: ResultName[UserTable])(rs: WrappedResultSet): UserTable = {
      UserTable(
        id = rs.get[UUID](p.id),
        username = rs.get[String](p.username),
        password = rs.get[String](p.password),
        email = rs.get[String](p.email),
        role = rs.get[UserRole.Value](p.role)
      )
    }
  }
}