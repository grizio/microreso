scalaVersion := Dependencies.scalaVersion

libraryDependencies ++= Seq(
  Dependencies.akkaActor,
  Dependencies.akkaStream,
  Dependencies.akkaHttp,
  Dependencies.akkaHttpSpray,
  Dependencies.cats,
  Dependencies.circeCore,
  Dependencies.circeGeneric,
  Dependencies.circeJawn,
  Dependencies.flyway,
  Dependencies.h2,
  Dependencies.logback,
  Dependencies.postgresql,
  Dependencies.scalikeJDBC
)

guardrailTasks in Compile := List(
  ScalaServer(
    file("../shared/openapi.json"),
    pkg="microreso.system.http.api",
    framework = "akka-http"
  )
)

mainClass in compile := Some("microreso.Main")
mainClass in run := Some("microreso.Main")