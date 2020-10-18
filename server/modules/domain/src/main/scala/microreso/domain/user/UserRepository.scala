package microreso.domain.user

import microreso.domain.user.model.User

import scala.concurrent.Future

trait UserRepository {
  def insert(user: User): Future[User]
}
