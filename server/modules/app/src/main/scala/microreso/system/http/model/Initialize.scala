package microreso.system.http.model

import microreso.domain.organisation.model.OrganisationCode
import microreso.macros.Json
import spray.json.RootJsonFormat

case class Initialize(
  code: String,
  name: String
) {
  def toDomain: microreso.domain.organisation.Initializer.Initialize = {
    microreso.domain.organisation.Initializer.Initialize(
      code = OrganisationCode(code),
      name = name
    )
  }
}

object Initialize {
  implicit val format: RootJsonFormat[Initialize] = Json.format
}