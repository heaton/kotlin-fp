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
            immutableListOf(1, 2, 3).map {it * 2}.toList() shouldBe listOf(2, 4, 6)
        }
    }
})