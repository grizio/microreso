scalaVersion := Dependencies.scalaVersion

libraryDependencies ++= Seq(
  Dependencies.akkaHttpSpray % Provided,
  Dependencies.scalaReflect
)