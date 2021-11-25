package me.heaton

import me.heaton.CollectionsFp.doubleOf
import me.heaton.CollectionsFp.evenOf
import me.heaton.CollectionsFp.oddOf
import me.heaton.CollectionsFp.sumOf
import me.heaton.CollectionsFp.tripleOf
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class CollectionsFpSpec : WordSpec({
    "Collections" should {
        "sum up a list" {
            sumOf(listOf(1, 2, 3)) shouldBe 6
        }

        "sum up another list" {
            sumOf(listOf(BigDecimal(1), BigDecimal(2), BigDecimal(3))) shouldBe BigDecimal(6)
        }

        "add up a list of strings" {
            sumOf(listOf("1", "2", "3")) shouldBe "123"
        }

        "double a list" {
            doubleOf(listOf(1, 2, 3)) shouldBe listOf(2, 4, 6)
        }

        "triple a list" {
            tripleOf(listOf(1, 2, 3)) shouldBe listOf(3, 6, 9)
        }

        "get evens from a list" {
            evenOf(listOf(1, 2, 3)) shouldBe listOf(2)
        }

        "get odds from a list" {
            oddOf(listOf(1, 2, 3)) shouldBe listOf(1, 3)
        }
    }
})