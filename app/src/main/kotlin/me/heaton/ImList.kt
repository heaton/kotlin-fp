package me.heaton

sealed interface ImList<T> {
    fun <R> fold(acc: R, f: (R, T) -> R): R
    fun <R> foldRight(acc: R, f: (R, T) -> R): R
    infix fun <O> zip(other: ImList<O>): ImList<Pair<T, O>>
}

class EmptyImList<T> : ImList<T> {
    override fun <R> fold(acc: R, f: (R, T) -> R): R = acc
    override fun <R> foldRight(acc: R, f: (R, T) -> R): R = acc
    override fun <O> zip(other: ImList<O>): ImList<Pair<T, O>> = EmptyImList()
    override fun equals(other: Any?): Boolean = other != null && javaClass === other.javaClass
    override fun hashCode(): Int = 0
}

data class NonEmptyImList<T>(private val e: T, private val tail: ImList<T>) : ImList<T> {
    override fun <R> fold(acc: R, f: (R, T) -> R): R = tail.fold(f(acc, e), f)
    override fun <R> foldRight(acc: R, f: (R, T) -> R): R = f(tail.foldRight(acc, f), e)
    override fun <O> zip(other: ImList<O>): ImList<Pair<T, O>> =
        if (other is NonEmptyImList) NonEmptyImList(Pair(e, other.e), tail.zip(other.tail))
        else EmptyImList()
}

fun <T> emptyImList(): ImList<T> = EmptyImList()

fun <T> imListOf(vararg es: T): ImList<T> = es.toList().foldRight(emptyImList()) { e, acc -> acc.ahead(e) }

infix fun <T> ImList<T>.ahead(e: T): ImList<T> = NonEmptyImList(e, this)

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