package me.heaton

import java.lang.Integer.max

sealed interface ImList<T> {
    val size: Int
    fun <R> fold(acc: R, f: (R, T) -> R): R
    fun <R> foldRight(acc: R, f: (R, T) -> R): R
    infix fun <O> zip(other: ImList<O>): ImList<Pair<T, O>>
}

class EmptyImList<T> : ImList<T> {
    override val size = 0
    override fun <R> fold(acc: R, f: (R, T) -> R): R = acc
    override fun <R> foldRight(acc: R, f: (R, T) -> R): R = acc
    override fun <O> zip(other: ImList<O>): ImList<Pair<T, O>> = EmptyImList()
    override fun equals(other: Any?): Boolean = other != null && javaClass === other.javaClass
    override fun hashCode(): Int = 0
}

data class NonEmptyImList<T>(private val e: T, private val tail: ImList<T>, override val size: Int) : ImList<T> {
    override fun <R> fold(acc: R, f: (R, T) -> R): R = tail.fold(f(acc, e), f)
    override fun <R> foldRight(acc: R, f: (R, T) -> R): R = f(tail.foldRight(acc, f), e)
    override fun <O> zip(other: ImList<O>): ImList<Pair<T, O>> =
        if (other is NonEmptyImList) NonEmptyImList(e to other.e, tail.zip(other.tail), size)
        else EmptyImList()
}

fun <T> emptyImList(): ImList<T> = EmptyImList()

fun <T> imListOf(vararg es: T): ImList<T> = es.toList().foldRight(emptyImList()) { e, acc -> acc.ahead(e) }

infix fun <T> ImList<T>.ahead(e: T): ImList<T> = NonEmptyImList(e, this, this.size + 1)

fun <T> ImList<T>.reverse(): ImList<T> = fold(emptyImList(), ImList<T>::ahead)

fun <T> ImList<T>.toList(): List<T> = fold(emptyList(), List<T>::plus)

fun <T> ImList<T>.toSet(): Set<T> = fold(emptySet(), Set<T>::plus)

infix fun <T, R> ImList<T>.map(f: (T) -> R): ImList<R> = foldRight(emptyImList()) { acc, e -> acc ahead f(e) }

infix fun <T> ImList<T>.filter(f: (T) -> Boolean): ImList<T> =
    foldRight(emptyImList()) { acc, e -> if (f(e)) acc ahead e else acc }

operator fun <T> ImList<T>.plus(other: ImList<T>) = foldRight(other, ImList<T>::ahead)

operator fun <T> ImList<T>.minus(other: ImList<T>) = other.toSet().let { others -> filter { !others.contains(it) } }

infix fun <T> ImList<T>.intersect(other: ImList<T>) = filter(other.toSet()::contains)

fun <T> ImList<ImList<T>>.flatten() = fold(emptyImList(), ImList<T>::plus)

infix fun <T, R> ImList<T>.flatMap(f: (T) -> ImList<R>) = map(f).flatten()

operator fun <T, O> ImList<T>.times(other: ImList<O>): ImList<Pair<T, O>> = flatMap { a ->
    other.map { b -> a to b }
}

infix fun <T, K> ImList<T>.groupBy(f: (T) -> K): Map<K, ImList<T>> = foldRight(emptyMap()) { map, e ->
    f(e).let { key -> map + (key to (map.getOrDefault(key, emptyImList()) ahead e)) }
}

infix fun <T> ImList<T>.partition(f: (T) -> Boolean) = filter(f) to filter { !f(it) }

private data class SplitHelper<T>(val acc: ImList<ImList<T>>, val eacc: ImList<T>, val s: Int, val r: Int, val i: Int)

infix fun <T> ImList<T>.split(n: Int): ImList<ImList<T>> =
    foldRight(SplitHelper<T>(emptyImList(), emptyImList(), size, n - 1, size / n)) { helper, e ->
        with(helper) {
            if (i == 1)
                SplitHelper(acc ahead (eacc ahead e), emptyImList(), s - 1, r - 1, (s - 1) / max(r, 1))
            else
                SplitHelper(acc, eacc ahead e, s - 1, r, i - 1)
        }
    }.acc