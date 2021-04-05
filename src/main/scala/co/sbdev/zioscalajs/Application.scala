package co.sbdev.zioscalajs

import co.sbdev.zioscalajs.RunProgram.RunProgram
import zio.random.Random
import zio._

object Application extends App {
  val program: URIO[RunProgram, Unit] = {
    RunProgram
      .greet("John")
      .ignore
  }

  private val prepareEnvironment: URLayer[Random, RunProgram] = {
    RunProgram.live
  }

  override def run(args: List[String]): ZIO[ZEnv, Nothing, ExitCode] = program.provideLayer(prepareEnvironment).exitCode
}
