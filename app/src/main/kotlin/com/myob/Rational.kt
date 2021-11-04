package com.myob

class Rational(x: Int, y: Int) {
    init {
        require(y != 0) { "denominator can not be 0" }
    }

    constructor(x: Int) : this(x, 1)

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    private val g = gcd(x, y)
    private val numer = x / g
    private val denom = y / g

    private val sdenom by lazy { if (denom == 1) "" else "/$denom" }
    fun show(): String = "$numer$sdenom"

    operator fun compareTo(other: Rational): Int = numer * other.denom - other.numer * denom

    operator fun unaryMinus(): Rational = Rational(-numer, denom)

    operator fun plus(that: Rational) = Rational(numer * that.denom + that.numer * denom, denom * that.denom)

    operator fun minus(that: Rational) = this + -that

    operator fun times(that: Rational) = Rational(numer * that.numer, denom * that.denom)

    operator fun div(that: Rational) = Rational(numer * that.denom, denom * that.numer)

    private infix fun equal(that: Rational) = numer * that.denom == denom * that.numer

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        return other is Rational && (this equal other)
    }

    override fun hashCode(): Int {
        var result = numer
        result = 31 * result + denom
        return result
    }

}
