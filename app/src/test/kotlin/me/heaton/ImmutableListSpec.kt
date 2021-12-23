package me.heaton

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class ImmutableListSpec : WordSpec({
    "Immutable List" should {
        "fold" {
            immutableListOf(1, 2, 3).fold(0) { a, b -> a + b } shouldBe 6
        }

        "to list" {
            immutableListOf(1, 2, 3).toList() shouldBe listOf(1, 2, 3)
        }

        "map" {
            immutableListOf(1, 2, 3).map { it * 2 } shouldBe immutableListOf(2, 4, 6)
        }

        "reverse" {
            immutableListOf(1, 2, 3).reverse() shouldBe immutableListOf(3, 2, 1)
        }

        "filter" {
            immutableListOf(1, 2, 3) filter { it % 2 != 0 } shouldBe immutableListOf(1, 3)
        }

        "+" {
            immutableListOf(1, 2, 3) + immutableListOf(4, 5) shouldBe immutableListOf(1, 2, 3, 4, 5)
        }
    }
})