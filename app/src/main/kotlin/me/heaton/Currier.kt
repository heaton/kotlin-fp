package me.heaton

object Currier {
    fun <A, B, R> curred(f: (A, B) -> R): (A) -> (B) -> R = { a -> { b -> f(a, b) } }
}