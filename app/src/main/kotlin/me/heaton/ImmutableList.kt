package me.heaton

sealed interface ImmutableList<T> {
    fun <R> fold(initialState: R, f: (R, T) -> R): R

    fun <R> foldRight(initialState: R, f: (R, T) -> R): R
}

class EmptyImmutableList<T> : ImmutableList<T> {
    override fun <R> fold(initialState: R, f: (R, T) -> R): R = initialState
    override fun <R> foldRight(initialState: R, f: (R, T) -> R): R = initialState
}

class NonEmptyImmutableList<T>(private val h: T, private val t: ImmutableList<T>) : ImmutableList<T> {
    override fun <R> fold(initialState: R, f: (R, T) -> R): R = t.fold(f(initialState, h), f)
    override fun <R> foldRight(initialState: R, f: (R, T) -> R): R = f(t.foldRight(initialState, f), h)
}

private fun <T> ImmutableList<T>.ahead(e: T) = NonEmptyImmutableList(e, this)

fun <T> emptyImmutableList(): ImmutableList<T> = EmptyImmutableList()

fun <T> immutableListOf(vararg items: T): ImmutableList<T> =
    items.foldRight(emptyImmutableList()) { head, tail -> tail.ahead(head) }

fun <T> ImmutableList<T>.toList(): List<T> = fold(emptyList(), List<T>::plus)

fun <T> ImmutableList<T>.reverse(): ImmutableList<T>

fun <T, R> ImmutableList<T>.map(f: (T) -> R): ImmutableList<R> =
    foldRight(emptyImmutableList()) { acc, e -> NonEmptyImmutableList(f(e), acc) }

fun <T> ImmutableList<T>.filter(f: (T) -> Boolean): ImmutableList<T>

fun <T> ImmutableList<T>.plus(other: ImmutableList<T>): ImmutableList<T>

fun <T> ImmutableList<ImmutableList<T>>.flatten(): ImmutableList<T>

fun <T> ImmutableList<T>.flatMap(f: (T) -> ImmutableList<T>): ImmutableList<T>

fun <K, T> ImmutableList<T>.groupBy(f: (T) -> K): Map<K, ImmutableList<T>>