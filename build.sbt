enablePlugins(ScalaJSPlugin)

name := "zioscalajs"

version := "0.1"

scalaVersion := "2.13.3"

scalaJSUseMainModuleInitializer := true

scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.ESModule) }

val zioVersion = "1.0.4"

libraryDependencies ++= Seq(
  "dev.zio"      %%% "zio"         % zioVersion,
  "dev.zio"      %% "zio-test"     % zioVersion % "test",
  "dev.zio"      %% "zio-test-sbt" % zioVersion % "test",
  "org.scala-js" %%% "scalajs-dom" % "1.1.0"
)

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
