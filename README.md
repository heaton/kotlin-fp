# Functional Programming in Kotlin

Demonstrate how we can write functional code in Kotlin.

## What is Functional Programming
* In a restricted sense, functional programming (FP) mean programming without mutable variables, assignments, loops, and other imperative control structures.
* In a wider sense, functional programming means focusing on the functions.
* In particular, functions can be values that are produced, consumed, and composed.

## Foundation

### Basic Kotlin Syntax

#### Kata
Implement a class to support basic calculation for rational numbers.

#### Code
* Test: [RationalSpec](app/src/test/kotlin/me/heaton/RationalSpec.kt)
* Implementation: [Rational](app/src/main/kotlin/me/heaton/Rational.kt)

#### Reference
* [Kotlin](https://kotlinlang.org/docs/home.html)
* [Kotlin Operator Overload](https://kotlinlang.org/docs/reference/operator-overloading.html)
* [Kotest](https://kotest.io/)

### Basic Functional Programming

#### Recursion
Recursion can be used to avoid mutable variables and loops.

##### Kata
Implement a function to add integers from 0 to n

##### Code
* Test: [IntSumSpec](app/src/test/kotlin/me/heaton/IntSumSpec.kt)
* Implementation: [IntSum](app/src/main/kotlin/me/heaton/IntSum.kt)

#### Immutable Collection Structure
Pending

#### Collection Operations

##### Code
* Test: [CollectionFpSpec](app/src/test/kotlin/me/heaton/CollectionsFpSpec.kt)
* Implementation: [CollectionFp](app/src/main/kotlin/me/heaton/CollectionsFp.kt) 

#### Currying
Allow a multi-parameter function to be called in a way that passing the parameters one by one.

##### Code
* Test: [CurrierSpec](app/src/test/kotlin/me/heaton/CurrierSpec.kt)
* Implementation: [Currier](app/src/main/kotlin/me/heaton/Currier.kt)

## Advanced

Sorry, kotlin doesn't support advanced functional programming. Please check with Scala or Haskell.

### Reference
* [Applied Functional Programming with Scala](https://gist.github.com/jdegoes/97459c0045f373f4eaf126998d8f65dc)