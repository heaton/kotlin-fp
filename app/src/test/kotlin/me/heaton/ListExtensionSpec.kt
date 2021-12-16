package me.heaton

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import me.heaton.ListExtension.combinations

class ListExtensionSpec : WordSpec({
    "List patterns" should {
        "all combinations" {
            emptyList<Int>().combinations() shouldBe listOf(emptyList())
            listOf(1).combinations() shouldBe listOf(emptyList(), listOf(1))
            listOf(1, 2, 3).combinations() shouldBe listOf(
                emptyList(),
                listOf(1),
                listOf(2),
                listOf(1, 2),
                listOf(3),
                listOf(1, 3),
                listOf(2, 3),
                listOf(1, 2, 3)
            )
        }
    }
})