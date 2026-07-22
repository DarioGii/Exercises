package uk.co.darioghunneyware.leetcode75

import kotlin.math.max
import kotlin.math.min

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var mostWater = Int.MIN_VALUE

        while (left <= right) {
            val currLeft = height[left]
            val currRight = height[right]
            val lowestHeight = min(currLeft, currRight)
            val distance = right - left
            val currentWater = lowestHeight * distance
            mostWater = max(mostWater, currentWater)

            if (currLeft < currRight) {
                left++
            } else {
                right--
            }
        }

        return mostWater
    }
}
