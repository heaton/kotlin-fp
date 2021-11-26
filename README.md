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

#### Immutable Collection Structure and Basic Collection Operations

##### Kata
Implement a simple immutable list without using any variables

##### Code
* Test: [ImListSpec](app/src/test/kotlin/me/heaton/ImListSpec.kt)
* Implementation: [ImList](app/src/main/kotlin/me/heaton/ImList.kt)

##### Reference
* [Kotlin Collections](https://kotlinlang.org/docs/collections-overview.html)

#### Currying
Allow a multi-parameter function to be called in a way that passing the parameters one by one.

##### Code
* Test: [CurrierSpec](app/src/test/kotlin/me/heaton/CurrierSpec.kt)
* Implementation: [Currier](app/src/main/kotlin/me/heaton/Currier.kt)

#### An Example
An example to show how can we use the knowledge to simplify the business logic.

##### Problem
Build the logic to manage a class. It needs to support:
* absent report: who applied the course but not show for each class
* attendance report: who applied the course and show for each class
* extra attendance report: the class accept unregistered attendees if there is a space, report who attended as the backup for each class
* generate invoice for all the attendees who applied the course or attended the classes

##### Code
* Test: [ClassroomCoreSpec](app/src/test/kotlin/me/heaton/classroom/ClassroomCoreSpec.kt)
* Implementation: [ClassroomCore](app/src/main/kotlin/me/heaton/classroom/ClassroomCore.kt)

## Advanced

Sorry, kotlin doesn't support advanced functional programming. Please check with Scala or Haskell.

### Reference
* [Applied Functional Programming with Scala](https://gist.github.com/jdegoes/97459c0045f373f4eaf126998d8f65dc)