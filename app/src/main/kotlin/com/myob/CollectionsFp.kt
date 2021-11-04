package com.myob

import java.math.BigDecimal

object CollectionsFp {
    fun sumOf(intList: List<Int>): Int = fold(0, { b, a -> a + b }, intList)

    fun sumOf(numList: List<BigDecimal>): BigDecimal = fold(BigDecimal(0), { b, a -> a + b }, numList)

    fun sumOf(stringList: List<String>): String = fold("", { b, a -> a + b }, stringList)

    fun <T, R> fold(initialValue: R, a: (R, T) -> R, list: List<T>): R =
        if (list.isEmpty()) initialValue else a(fold(initialValue, a, list.drop(1)), list.first())

    fun doubleOf(intList: List<Int>): List<Int> =
        fold(emptyList(), { acc, a -> acc + (a * 2) }, intList)

    fun sumOfOo(intList: List<Int>): Int {
        var s = 0
        intList.forEach { s += it }
        return s
    }

}