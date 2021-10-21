package com.myob

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class RationalSpec : WordSpec({
    "Rational" should {
        "display 1/2" {
            Rational(1, 2).show() shouldBe "1/2"
        }

        "display 1 for 1/1" {
            Rational(1, 1).show() shouldBe "1"
        }
    }
})