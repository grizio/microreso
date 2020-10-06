package microreso.macros

import spray.json.RootJsonFormat

import scala.reflect.macros.blackbox

class JsonImplementation(val c: blackbox.Context) {
  import c.universe._

  def format[A: WeakTypeTag]: Expr[RootJsonFormat[A]] = {
    val tag = implicitly[WeakTypeTag[A]]
    val tpe = tag.tpe
    val fields = extractFields(tag.tpe)

    c.Expr[RootJsonFormat[A]](
      q"""
          import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
          import spray.json.DefaultJsonProtocol._
          new RootJsonFormat[${tpe}] with spray.json.DefaultJsonProtocol {
            def write(p: ${tpe}) = {
              val fields = new collection.mutable.ListBuffer[(String, spray.json.JsValue)]
              fields.sizeHint(${fields.size} * ${fields.size + 1})
        ..${
        fields.zipWithIndex.map { case (field, index) =>
          q"""
                  fields ++= productElement2Field[${field.infoIn(tpe)}](${field.name.toTermName.toString}, p, ${index})
          """
        }
      }
              spray.json.JsObject(fields.toSeq: _*)
            }

            def read(value: spray.json.JsValue) = {
        ..${
        fields.zipWithIndex.map { case (field, index) =>
          q"""
                  val ${TermName(s"parameter${index}")} = fromField[${field.infoIn(tpe)}](value, ${field.name.toTermName.toString})
          """
        }
      }
              new ${tpe}(..${fields.indices.map(index => TermName(s"parameter${index}"))})
            }
          }
      """
    )
  }

  private def extractFields(tpe: Type): Seq[Symbol] = {
    tpe.decls
      .collectFirst {
        case method: MethodSymbol if method.isPrimaryConstructor => method
      }
      .get
      .paramLists
      .head
  }
}