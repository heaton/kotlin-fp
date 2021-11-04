package com.myob

object CollectionsFp {
    fun sumOf(intList: List<Int>): Int =
        if(intList.isEmpty()) 0 else intList.first() + sumOf(intList.drop(1))

    fun sumOfOo(intList: List<Int>): Int {
        var s = 0
        intList.forEach { s += it }
        return s
    }

}