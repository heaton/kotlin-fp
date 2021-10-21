package com.myob

import com.myob.IntSum.sumUp
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class IntSumSpec : WordSpec({
    "Int Sum" should {
        "sum up from 1 to 100" {
            sumUp(1, 100) shouldBe 5050
        }
    }

})