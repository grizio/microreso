package microreso.system.db

import java.sql.ResultSet
import java.util.UUID

import microreso.domain.user.model.UserRole
import scalikejdbc._

object DatabaseBinders {
  implicit val uuidTypeBinder: TypeBinder[UUID] = new TypeBinder[UUID] {
    def apply(rs: ResultSet, label: String): UUID = UUID.fromString(rs.getString(label))

    def apply(rs: ResultSet, index: Int): UUID = UUID.fromString(rs.getString(index))
  }

  implicit val uuidBinderFactory: ParameterBinderFactory[UUID] = ParameterBinderFactory[UUID] {
    value => (stmt, idx) => stmt.setObject(idx, value )
  }

  implicit val userRoleTypeBinder: TypeBinder[UserRole.Value] = new TypeBinder[UserRole.Value] {
    def apply(rs: ResultSet, label: String): UserRole.Value = UserRole.withName(rs.getString(label))

    def apply(rs: ResultSet, index: Int): UserRole.Value = UserRole.withName(rs.getString(index))
  }

  implicit val userRoleBinderFactory: ParameterBinderFactory[UserRole.Value] = ParameterBinderFactory[UserRole.Value] {
    value => (stmt, idx) => stmt.setString(idx, value.toString)
  }
}
