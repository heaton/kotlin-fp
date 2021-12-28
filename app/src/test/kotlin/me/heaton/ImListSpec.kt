package me.heaton

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import me.heaton.CollectionsFpBlog.split

class ImListSpec : WordSpec({
    "Immutable list" should {
        "size" {
            imListOf(1, 2, 3).size shouldBe 3
        }

        "toList" {
            imListOf(1, 2, 1, 3).toList() shouldBe listOf(1, 2, 1, 3)
        }

        "toSet" {
            imListOf(1, 2, 1, 3).toSet() shouldBe setOf(1, 2, 3)
        }

        "reverse" {
            imListOf(1, 2, 3).reverse() shouldBe imListOf(3, 2, 1)
        }

        "map" {
            imListOf(1, 2, 3).map { it * 2 } shouldBe imListOf(2, 4, 6)
            imListOf(1, 2, 3).map(Int::toString) shouldBe imListOf("1", "2", "3")
        }

        "filter" {
            imListOf(1, 2, 3).filter { it % 2 != 0 } shouldBe imListOf(1, 3)
        }

        "union 2 lists by +" {
            (imListOf(1, 2, 3) + imListOf(4, 5, 6)) shouldBe imListOf(1, 2, 3, 4, 5, 6)
        }

        "remove elements by -" {
            (imListOf(1, 2, 3) - imListOf(1, 2)) shouldBe imListOf(3)
        }

        "return the shared element" {
            (imListOf(1, 2, 3) intersect imListOf(1, 2, 4)) shouldBe imListOf(1, 2)
        }

        "flat the list" {
            imListOf(
                imListOf(1, 2),
                imListOf(3),
                imListOf(4, 5, 6)
            ).flatten() shouldBe imListOf(1, 2, 3, 4, 5, 6)
        }

        "flat map" {
            imListOf(1, 2).flatMap { x ->
                imListOf(3, 4).map { y -> x * y }
            } shouldBe imListOf(3, 4, 6, 8)
        }

        "group by" {
            imListOf(1, 2, 3, 4, 5).groupBy { it % 2 } shouldBe mapOf(
                0 to imListOf(2, 4),
                1 to imListOf(1, 3, 5)
            )
        }

        "multiple" {
            imListOf(1, 2) * imListOf(3, 4) shouldBe imListOf(Pair(1, 3), Pair(1, 4), Pair(2, 3), Pair(2, 4))
        }

        "zip" {
            imListOf(1, 2, 3) zip imListOf(2, 4, 8) shouldBe imListOf(Pair(1, 2), Pair(2, 4), Pair(3, 8))
        }

        "partition" {
            imListOf(1, 2, 3) partition { it % 2 != 0 } shouldBe (imListOf(1, 3) to imListOf(2))
        }

        "split" {
            imListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12) split 5 shouldBe imListOf(
                imListOf(1, 2, 3),
                imListOf(4, 5, 6),
                imListOf(7, 8),
                imListOf(9, 10),
                imListOf(11, 12)
            )
        }

        "par fold" {
            (1..100).fold(emptyImList(), ImList<Int>::ahead).parFold(0, Int::plus, Int::plus) shouldBe 5050
        }
    }
})