package microreso.system.http.model

import microreso.macros.Json
import spray.json.RootJsonFormat

case class Organisation(
  code: String,
  name: String
)

object Organisation {
  implicit val format: RootJsonFormat[Organisation] = Json.format

  def fromDomain(organisation: microreso.domain.organisation.model.Organisation): Organisation = {
    Organisation(
      code = organisation.code.value,
      name = organisation.name
    )
  }
}