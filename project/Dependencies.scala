import sbt._

object Dependencies {
  val scalaVersion = "2.13.3"

  val akkaActor = "com.typesafe.akka" %% "akka-actor" % "2.6.9"
  val akkaStream = "com.typesafe.akka" %% "akka-stream" % "2.6.9"
  val akkaHttp = "com.typesafe.akka" %% "akka-http" % "10.2.1"
  val akkaHttpSpray = "com.typesafe.akka" %% "akka-http-spray-json" % "10.2.1"
  val cats = "org.typelevel" %% "cats-core" % "2.2.0"
  val flyway = "org.flywaydb" % "flyway-core" % "7.0.0"
  val h2 = "com.h2database" % "h2" % "1.4.200"
  val logback = "ch.qos.logback" % "logback-classic" % "1.2.3"
  val postgresql = "org.postgresql" % "postgresql" % "42.2.16"
  val scalaReflect = "org.scala-lang" % "scala-reflect" % scalaVersion
  val scalikeJDBC = "org.scalikejdbc" %% "scalikejdbc" % "3.5.0"
}
