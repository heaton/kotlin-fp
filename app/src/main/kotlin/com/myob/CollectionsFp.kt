package com.myob

import java.math.BigDecimal

object CollectionsFp {
    fun sumOf(intList: List<Int>): Int = fold(0, { acc, a -> acc + a }, intList)

    fun sumOf(numList: List<BigDecimal>): BigDecimal = fold(BigDecimal(0), { acc, a -> acc + a }, numList)

    fun sumOf(stringList: List<String>): String = fold("", { acc, a -> acc + a }, stringList)

    fun doubleOf(intList: List<Int>): List<Int> = map(intList) { it * 2 }

    fun tripleOf(intList: List<Int>): List<Int> = map(intList) { it * 3 }

    private fun <T, R> map(list: List<T>, f: (T) -> R): List<R> =
        fold(emptyList(), { acc, a -> acc + f(a) }, list)

    fun evenOf(list: List<Int>): List<Int> = filter(list) {it % 2 == 0}

    private fun <T> filter(list: List<T>, f: (T) -> Boolean): List<T> =
        fold(emptyList(), { acc, i -> if (f(i)) acc + i else acc }, list)

    fun oddOf(list: List<Int>): List<Int> = filter(list) {it % 2 != 0}

    fun <T, R> fold(acc: R, f: (R, T) -> R, list: List<T>): R =
        if (list.isEmpty()) acc else fold(f(acc, list.first()), f, list.drop(1))

    fun <T, R> foldOo(acc: R, f: (R, T) -> R, list: List<T>): R {
        var a = acc
        for (t in list) {
            a = f(a, t)
        }
        return a
    }

    fun sumOfOo(intList: List<Int>): Int {
        var s = 0
        intList.forEach { s += it }
        return s
    }

}