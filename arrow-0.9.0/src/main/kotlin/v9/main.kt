package v9

import arrow.effects.extensions.io.fx.fx
import kotlinx.coroutines.delay
import kotlin.system.measureTimeMillis

fun main() {
  useParMapN().unsafeRunSync()
  useTraverse().unsafeRunSync()
}

fun useParMapN() = fx {
  val time = measureTimeMillis {
    !NonBlocking.parMapN(
      effect { delay(1000) },
      effect { delay(1000) },
      effect { delay(1000) }
    ) { _, _, _ -> Unit }
  }
  !effect { println("parMapN time: $time") }
}

fun useTraverse() = fx {
  val time = measureTimeMillis {
    !NonBlocking.parTraverse(listOf(
      effect { delay(1000) },
      effect { delay(1000) },
      effect { delay(1000) }
    )) {}
  }
  !effect { println("parTraverse time: $time") }
}
