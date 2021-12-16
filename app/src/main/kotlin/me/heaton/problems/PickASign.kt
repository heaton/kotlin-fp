package me.heaton.problems

import me.heaton.ListExtension.combinations

/**
 * https://algodaily.com/challenges/pick-a-sign
 */
object PickASign {
    fun numSignWays(ints: List<Int>, target: Int): Int = ints.combinations().let { c ->
        (c zip c.reversed()).count { it.first.sum() + it.second.sumOf { x -> -x } == target }
    }
}