package uk.co.darioghunneyware.leetcode75

import java.util.Stack
import kotlin.math.abs

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 *
 *
 *
 * Example 1:
 *
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * Example 2:
 *
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 *
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 * */

class AsteroidCollision {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        if (asteroids.all { it > 0 } || asteroids.all { it < 0 }) return asteroids

        if (asteroids.size == 2) {
            val first = asteroids.first()
            val last = asteroids.last()

            return if (abs(first) > abs(last)) {
                intArrayOf(first)
            } else if (abs(last) > abs(first)) {
                intArrayOf(last)
            } else {
                intArrayOf()
            }
        }

        val asteroidStack = Stack<Int>()
//        asteroidStack.addAll(asteroids.toList())

        for (asteroid in asteroids) {
            var destroyed = false

            while (asteroidStack.isNotEmpty() && asteroid < 0 && asteroidStack.peek() > 0) {
                val topAsteroid = asteroidStack.peek()

                if (asteroid + topAsteroid == 0) {
                    asteroidStack.pop()
                    destroyed = true
                    break
                } else if (asteroid + topAsteroid < 0) {
                    asteroidStack.pop()
                } else {
                    destroyed = true
                    break
                }
            }

            if (!destroyed) asteroidStack.push(asteroid)
        }

        return asteroidStack.reversed().toIntArray()
    }
}
