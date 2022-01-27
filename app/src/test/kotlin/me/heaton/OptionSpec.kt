package me.heaton

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class OptionSpec : WordSpec({
    "Option" should {
        "exists and forall" {
            var s: String? = null
            val c: (String) -> Boolean = { it == "Heaton" }
            s.exists(c) shouldBe false
            s.forall(c) shouldBe true

            s = "Heaton"
            s.exists(c) shouldBe true
            s.forall(c) shouldBe true

            s = "Not Heaton"
            s.exists(c) shouldBe false
            s.forall(c) shouldBe false
        }
    }
})
