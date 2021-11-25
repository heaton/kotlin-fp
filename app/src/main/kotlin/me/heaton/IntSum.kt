package me.heaton

object IntSum {
    fun sumUp(from: Int, to: Int): Int =
        if (from > to) 0 else from + sumUp(from + 1, to)
}