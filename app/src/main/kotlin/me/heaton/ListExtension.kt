package me.heaton

object ListExtension {
    fun <T> List<T>.combinations(): List<List<T>> = fold(listOf(emptyList())) { acc, e ->
        acc + acc.map { it + e }
    }
}