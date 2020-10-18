package microreso.domain.initialize

import cats.data._
import cats.implicits._
import microreso.domain.organisation.OrganisationRepository
import microreso.domain.organisation.model.{Organisation, OrganisationCode}
import microreso.domain.user.UserRepository
import microreso.domain.user.model.{User, UserId, UserRole, Username}
import org.mindrot.jbcrypt.BCrypt

import scala.concurrent.{ExecutionContext, Future}

class Initializer(
  organisationRepository: OrganisationRepository,
  userRepository: UserRepository
)(
  implicit ec: ExecutionContext
) {

  import Initializer._

  def initialize(input: Initialize): Future[InitializationResult] = {
    (for {
      isInitialized <- EitherT.liftF(organisationRepository.isInitialized())
      _ <- EitherT.cond[Future](!isInitialized, (), AlreadyInitialized)
      organisation = Organisation(
        code = input.code,
        name = input.name
      )
      admin = User(
        id = UserId.generate(),
        username = Username(input.admin.username),
        password = BCrypt.hashpw(input.admin.rawPassword, BCrypt.gensalt()),
        email = input.admin.email,
        role = UserRole.admin
      )
      _ <- EitherT.liftF[Future, InitializationResult, Organisation](organisationRepository.initialize(organisation))
      _ <- EitherT.liftF[Future, InitializationResult, User](userRepository.insert(admin))
    } yield {
      Initialized
    })
      .merge[InitializationResult]
  }

  def checkInitialization(): Future[Boolean] = {
    organisationRepository.isInitialized()
  }
}

object Initializer {

  case class Initialize(code: OrganisationCode, name: String, admin: Admin)

  case class Admin(username: String, rawPassword: String, email: String)

  sealed trait InitializationResult

  case object Initialized extends InitializationResult

  case object AlreadyInitialized extends InitializationResult

}