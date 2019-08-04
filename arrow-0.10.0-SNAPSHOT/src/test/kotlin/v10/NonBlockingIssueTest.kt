package v10

import org.junit.jupiter.api.Assertions.assertTimeout
import org.junit.jupiter.api.Test
import java.time.Duration

internal class NonBlockingIssueTest {

  @Test
  fun `parMapN executes in parallel`() {
    assertTimeout(Duration.ofMillis(1500)) {
      useParMapN().unsafeRunSync()
    }
  }

  @Test
  fun `parTraverse executes in parallel`() {
    assertTimeout(Duration.ofMillis(1500)) {
      useTraverse().unsafeRunSync()
    }
  }
}
