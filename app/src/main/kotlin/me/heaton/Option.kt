package me.heaton

fun <T> T?.exists(c: (T) -> Boolean) = this != null && c(this)
fun <T> T?.forall(c: (T) -> Boolean) = this == null || c(this)