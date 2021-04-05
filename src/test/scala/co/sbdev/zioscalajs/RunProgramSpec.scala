package co.sbdev.zioscalajs

import co.sbdev.zioscalajs.RunProgram.RunProgram
import zio.ULayer
import zio.random.Random
import zio.test.Assertion.{ equalTo, isRight }
import zio.test.mock.Expectation.value
import zio.test.mock.MockRandom
import zio.test.{ assertM, suite, testM, DefaultRunnableSpec }

object RunProgramSpec extends DefaultRunnableSpec {
  def spec = suite("RunProgram")(
    suite("greet")(
      testM("generates random greeting") {
        val randomMock: ULayer[Random] = MockRandom.NextIntBounded(equalTo(9), value(0))

        val env: ULayer[RunProgram] = (randomMock) >>> RunProgram.live
        val result                  = RunProgram.greet("John").either.provideLayer(env)
        assertM(result)(isRight(equalTo("Yo! John")))
      }
    )
  )
}
