package com.myob

import java.math.BigDecimal

object CollectionsFp {
    fun sumOf(intList: List<Int>): Int = f(0, { a, b -> a + b }, intList)

    fun sumOf(numList: List<BigDecimal>): BigDecimal = f(BigDecimal(0), { a, b -> a + b }, numList)

    fun sumOf(stringList: List<String>): String = f("", { a, b -> a + b }, stringList)

    fun <T> f(initialValue: T, a: (T, T) -> T, list: List<T>): T =
        if (list.isEmpty()) initialValue else a(list.first(), f(initialValue, a, list.drop(1)))

    fun sumOfOo(intList: List<Int>): Int {
        var s = 0
        intList.forEach { s += it }
        return s
    }

}