package v10

import arrow.fx.IO
import arrow.fx.extensions.fx
import kotlinx.coroutines.delay
import kotlin.system.measureTimeMillis

fun main() {
  useParMapN().unsafeRunSync()
  useTraverse().unsafeRunSync()
}

fun useParMapN() = IO.fx {
  val time = measureTimeMillis {
    !NonBlocking.parMapN(
      effect { delay(1000) },
      effect { delay(1000) },
      effect { delay(1000) }
    ) { _, _, _ -> Unit }
  }
  !effect { println("parMapN time: $time") }
}

fun useTraverse() = IO.fx {
  val time = measureTimeMillis {
    !NonBlocking.parTraverse(listOf(
      effect { delay(1000) },
      effect { delay(1000) },
      effect { delay(1000) }
    )) {}
  }
  !effect { println("parTraverse time: $time") }
}
