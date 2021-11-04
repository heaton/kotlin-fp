package com.myob

import java.math.BigDecimal

object CollectionsFp {
    fun sumOf(intList: List<Int>): Int = fold(0, { acc, a -> acc + a}, intList)

    fun sumOf(numList: List<BigDecimal>): BigDecimal = fold(BigDecimal(0), { acc, a -> acc + a}, numList)

    fun sumOf(stringList: List<String>): String = fold("", { acc, a -> acc + a }, stringList)

    fun <T, R> fold(acc: R, f: (R, T) -> R, list: List<T>): R =
        if (list.isEmpty()) acc else fold(f(acc, list.first()), f, list.drop(1))

    fun doubleOf(intList: List<Int>): List<Int> =
        fold(emptyList(), { acc, a -> acc + (a * 2) }, intList)

    fun sumOfOo(intList: List<Int>): Int {
        var s = 0
        intList.forEach { s += it }
        return s
    }

}