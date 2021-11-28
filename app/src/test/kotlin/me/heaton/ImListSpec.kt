package me.heaton

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class ImListSpec : WordSpec({
    "Immutable list" should {
        "return head" {
            imListOf(1, 2).head() shouldBe 1
            imListOf(1, 2).tail().head() shouldBe 2
        }

        "toList" {
            imListOf(1, 2, 1, 3).toList() shouldBe listOf(1, 2, 1, 3)
        }

        "toSet" {
            imListOf(1, 2, 1, 3).toSet() shouldBe setOf(1, 2, 3)
        }

        "reverse" {
            imListOf(1, 2, 3).reverse().toList() shouldBe listOf(3, 2, 1)
        }

        "map" {
            imListOf(1, 2, 3).map { it * 2 }.toList() shouldBe listOf(2, 4, 6)
        }

        "filter" {
            imListOf(1, 2, 3).filter { it % 2 != 0 }.toList() shouldBe listOf(1, 3)
        }

        "union 2 lists by +" {
            (imListOf(1, 2, 3) + imListOf(4, 5, 6)).toList() shouldBe listOf(1, 2, 3, 4, 5, 6)
        }

        "remove elements by -" {
            (imListOf(1, 2, 3) - imListOf(1, 2)).toList() shouldBe listOf(3)
        }

        "return the shared element" {
            (imListOf(1, 2, 3) intersect imListOf(1, 2, 4)).toList() shouldBe listOf(1, 2)
        }

        "flat the list" {
            imListOf(
                imListOf(1, 2),
                imListOf(3),
                imListOf(4, 5, 6)
            ).flatten().toList() shouldBe listOf(1, 2, 3, 4, 5, 6)
        }

        "flat map" {
            imListOf(1, 2).flatMap { x ->
                imListOf(3, 4).map { y -> x * y }
            }.toList() shouldBe listOf(3, 4, 6, 8)
        }

        "group by" {
            imListOf(1, 2, 3, 4, 5).groupBy { it % 2 }.mapValues { it.value.toList() } shouldBe mapOf(
                Pair(0, listOf(2, 4)),
                Pair(1, listOf(1, 3, 5))
            )
        }
    }
})