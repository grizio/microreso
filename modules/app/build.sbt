scalaVersion := Dependencies.scalaVersion

libraryDependencies ++= Seq(
  Dependencies.akkaActor,
  Dependencies.akkaStream,
  Dependencies.akkaHttp,
  Dependencies.akkaHttpSpray,
  Dependencies.cats,
  Dependencies.flyway,
  Dependencies.h2,
  Dependencies.logback,
  Dependencies.postgresql,
  Dependencies.scalikeJDBC
)