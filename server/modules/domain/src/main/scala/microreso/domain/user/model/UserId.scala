package microreso.domain.user.model

import java.util.UUID

case class UserId(value: UUID) extends AnyVal

object UserId {
  def generate(): UserId = UserId(UUID.randomUUID())
}
