package microreso.macros

import spray.json.RootJsonFormat
import scala.language.experimental.macros

object Json {
  def format[A]: RootJsonFormat[A] = macro JsonImplementation.format[A]
}
