package me.heaton.problems

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import me.heaton.problems.PickASign.numSignWays

class PickASignSpec : WordSpec({
    "Pick a sign" should {
        "not find a target" {
            numSignWays(listOf(9, 6, 6), 10) shouldBe 0
            numSignWays(listOf(7, 4, 9), 0) shouldBe 0
            numSignWays(listOf(10, 7, 2, 9, 7, 7, 2, 7), 0) shouldBe 0
        }

        "find target" {
            numSignWays(listOf(10, 9, 4, 7, 5, 5, 4, 2, 2), 10) shouldBe 15
            numSignWays(listOf(1, 5, 7, 6), 5) shouldBe 2
        }
    }
})