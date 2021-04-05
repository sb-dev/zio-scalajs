package co.sbdev.zioscalajs

import org.scalajs.dom.document
import org.scalajs.dom.raw.Element
import zio._
import zio.random.Random

package object RunProgram {
  type RunProgram = Has[RunProgram.Service]

  object RunProgram {
    val live: URLayer[Random, RunProgram] = ZLayer.fromService { randomService => (name: String) =>
      {
        val greetings: Array[String] = Array(
          "Yo!",
          "Hi!",
          "Hello!",
          "Good morning.",
          "Good afternoon.",
          "Good evening.",
          "It’s nice to meet you.",
          "It’s a pleasure to meet you.",
          "Sup?"
        )

        for {
          greeting <- pickGreeting(greetings, randomService)
          message  = s"$greeting $name!"
          _        <- write(message)
        } yield message
      }
    }

    def greet(name: String): ZIO[RunProgram, Throwable, String] =
      ZIO.accessM(_.get.greet(name))

    private def pickGreeting(greetings: Array[String], randomService: Random.Service): ZIO[Any, Nothing, String] =
      greetings.length match {
        case 0 => ZIO.succeed("Oh no!")
        case n => randomService.nextIntBounded(n).map(greetings(_))
      }

    private def write(message: String): Task[Unit] =
      UIO.effectTotal {
        val element: Element = document.querySelector("#message")
        element.textContent = message
      }

    trait Service {
      def greet(name: String): Task[String]
    }
  }
}
