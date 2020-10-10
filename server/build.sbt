name := "microreso"

version := "0.1"

scalaVersion := Dependencies.scalaVersion

lazy val app = (project in file("modules/app"))
  .dependsOn(domain, macros)
lazy val domain = project in file("modules/domain")
lazy val macros = project in file("modules/macros")

scalacOptions ++= Seq(
  "-encoding", "utf8",
  "-Xfatal-warnings",
  "-deprecation",
  "-unchecked",
  "-language:implicitConversions",
  "-language:higherKinds"
)