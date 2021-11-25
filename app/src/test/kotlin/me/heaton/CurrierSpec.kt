package me.heaton

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import me.heaton.Currier.curred

class CurrierSpec : WordSpec({
    fun add(a: Int, b: Int) = a + b

    fun addCurried(a: Int) = { b: Int -> a + b }

    "Currier" should {
        "make a function curried" {
            add(1, 2) shouldBe addCurried(1)(2) // manually currying
            add(1, 2) shouldBe curred(::add)(1)(2) // use generic currying method
        }
    }
})