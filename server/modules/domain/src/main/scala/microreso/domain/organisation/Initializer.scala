package microreso.domain.organisation

import cats.data._
import cats.implicits._
import microreso.domain.organisation.model.{Organisation, OrganisationCode}

import scala.concurrent.{ExecutionContext, Future}

class Initializer(
  organisationRepository: OrganisationRepository
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
      result <- EitherT.liftF[Future, InitializationResult, Organisation](organisationRepository.initialize(organisation))
    } yield {
      Initialized(result)
    })
      .merge[InitializationResult]
  }

  def checkInitialization(): Future[Boolean] = {
    organisationRepository.isInitialized()
  }
}

object Initializer {

  case class Initialize(code: OrganisationCode, name: String)

  sealed trait InitializationResult

  case class Initialized(organisation: Organisation) extends InitializationResult

  case object AlreadyInitialized extends InitializationResult

}