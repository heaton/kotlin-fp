package com.myob

import com.myob.CollectionsFp.sumOf
import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class CollectionsFpSpec: WordSpec({
    "Collections" should {
        "sum up a list" {
            sumOf(listOf(1, 2, 3)) shouldBe 6
        }
    }
})