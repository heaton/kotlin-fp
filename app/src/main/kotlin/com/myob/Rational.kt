package com.myob

data class Rational(val x: Int, val y: Int) {
    fun show(): String {
        return "$x/$y"
    }

    operator fun compareTo(other: Rational): Int {
        return x * other.y - other.x * y
    }

    operator fun unaryMinus(): Rational = Rational(-x, y)
}
