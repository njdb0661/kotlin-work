// COMP2850 Portfolio: Week 3
// Tests for median()

import io.kotest.core.spec.style.FreeSpec
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.floats.plusOrMinus

const val tolerance = 0.000001f

@Suppress("Unused")
class MedianTest : FreeSpec({
    "Exception when size=0" {
        shouldThrow<IllegalArgumentException> {
            median(listOf())
        }
    }

    // Write four more tests here

    "median of a single element list" {
        median(listOf(5.0)) shouldBe 5.0
    }
    "median of a double element list" {
        median(listOf(5.0, 12.0)) shouldBe 8.5
    }
    "median of a triple element list" {
        median(listOf(7.0, 15.0, 11.0)) shouldBe 11.0
    }
    "median of a quadruple element list" {
        median(listOf(12.0, 2.0, 7.0, 20.0)) shouldBe 9.5
    }
})
