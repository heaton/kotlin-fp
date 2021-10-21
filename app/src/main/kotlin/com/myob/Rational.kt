package com.myob

data class Rational(val x: Int, val y: Int) {
    fun show(): String {
        return "$x/$y"
    }

}
