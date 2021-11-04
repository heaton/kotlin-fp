package com.myob

import com.myob.CollectionsFp.doubleOf
import com.myob.CollectionsFp.sumOf
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

class CollectionsFpSpec : WordSpec({
    "Collections" should {
        "sum up a list" {
            sumOf(listOf(1, 2, 3)) shouldBe 6
        }

        "sum up another list" {
            sumOf(listOf(BigDecimal(1), BigDecimal(2), BigDecimal(3))) shouldBe BigDecimal(6)
        }

        "add up a list of strings" {
            sumOf(listOf("1", "2", "3")) shouldBe "123"
        }

        "double a list" {
            doubleOf(listOf(1, 2, 3)) shouldBe listOf(2, 4, 6)
        }
    }
})