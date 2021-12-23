package me.heaton.problems

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import me.heaton.problems.RemoveIslands.removeIslands

class RemoveIslandsSpec : WordSpec({
    "Remove Islands" should {
        "remove nothing is it is empty" {
            removeIslands("") shouldBe ""
        }

        "remove islands when it is not a rectangle" {
            removeIslands(
                """
                0000
                0100
                0010
            """.trimIndent()
            ) shouldBe """
                0000
                0000
                0010
            """.trimIndent()
        }

        "remove islands" {
            removeIslands(
                """
                100000
                010111
                001010
                100010
                101100
                110011
            """.trimIndent()
            ) shouldBe """
                100000
                000111
                000010
                100010
                100000
                110011
            """.trimIndent()
        }
    }
})