ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .settings(
    name := "Scala-cats"
  )

val circeVersion = "0.14.1"
libraryDependencies += "org.typelevel" %% "cats-core" % "2.6.1"

libraryDependencies += "org.typelevel" %% "cats-effect" % "3.5.4"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)
addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")