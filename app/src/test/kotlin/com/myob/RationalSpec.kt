package com.myob

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.*
import java.lang.IllegalArgumentException

class RationalSpec : WordSpec({
    "Rational" should {
        "display 1/2" {
            Rational(1, 2).show() shouldBe "1/2"
            Rational(2, 4).show() shouldBe "1/2"
        }

        "display 1 for 1/1" {
            Rational(1, 1).show() shouldBe "1"
        }

        "compare the rational numbers" {
            (Rational(1, 2) > Rational(1, 3)) shouldBe true
            (Rational(1, 3) < Rational(1, 2)) shouldBe true
            -Rational(1, 2) shouldBe Rational(-1, 2)
        }

        "support operations" {
            Rational(1, 2) + Rational(1, 2) shouldBe Rational(1, 1)
            Rational(1, 2) - Rational(1, 2) shouldBe Rational(0, 1)
            Rational(1, 2) * 2 shouldBe Rational(1, 1)
            Rational(1, 1) / 2 shouldBe Rational(1, 2)
        }

        "throw error for x/0" {
            shouldThrow<IllegalArgumentException> {
                Rational(1, 0)
            }
        }
    }
})