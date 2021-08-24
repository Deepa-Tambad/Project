import sbt._

object Dependencies {

  lazy val typeSafeConfigVersion = "1.4.1"

  // https://mvnrepository.com/artifact/io.spray/spray-json
  lazy val sprayJson = "io.spray" %% "spray-json" % "1.3.6"

  // https://mvnrepository.com/artifact/org.scalatest/scalatest
  lazy val  scalaTest = "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test


  lazy val typeSafeConfig = "com.typesafe" % "config" % typeSafeConfigVersion

  def compileDependencies: Seq[ModuleID] =
    Seq(sprayJson, typeSafeConfig)
  def testDependencies: Seq[ModuleID] = Seq(scalaTest, typeSafeConfig)
}
