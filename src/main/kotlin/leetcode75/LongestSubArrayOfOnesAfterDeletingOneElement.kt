package leetcode75

import java.awt.SystemColor.window
import kotlin.math.max

/**
 * Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1]
 *
 * Output: 3
 *
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 *
 * Example 2:
 *
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 *
 * Output: 5
 *
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 *
 * Example 3:
 *
 * Input: nums = [1,1,1]
 * Output: 2
 * Explanation: You must delete one element.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i]  is either 0 or 1.
 * */

class LongestSubArrayOfOnesAfterDeletingOneElement {
    fun longestSubarray(nums: IntArray): Int {
        when (nums.size) {
            0, 1 -> return 0
        }

        if (nums.all { it == 0 }) return 0

        var zeroCount = 0
        var longestWindow = 0
        var start = 0

        for (i in 0 until nums.size) {
            if (nums[i] == 0) zeroCount++

            if (zeroCount > 1) {
                val (newStart, zeroes) = pointToNextZero(nums.toList(), start, i)
                start = newStart
                zeroCount = zeroes
            }

            longestWindow = max(i - start, longestWindow)
        }

        return longestWindow
    }

    private fun pointToNextZero(
        nums: List<Int>,
        start: Int,
        end: Int,
    ): Pair<Int, Int> {
        var begin = start
        var zeroes = 0

        while (start <= end) {
            if (nums[begin] == 0) begin++

            zeroes = nums.subList(begin, end + 1).count { it == 0 }

            if (zeroes <= 1) break else begin++
        }

        return begin to zeroes
    }

    fun longestSubarrayAttempt1(nums: IntArray): Int {
        when (nums.size) {
            0 -> return 0
            1 -> {
                return if (nums.first() == 0) 0 else 1
            }
        }

        var lowerBound = 0
        var upperBound = 1
        var count = 0

        while (lowerBound < nums.size - upperBound && upperBound < nums.size) {
            val window =
                nums
                    .toMutableList()
                    .subList(lowerBound, upperBound + 1)

            if (window.isNotEmpty()) {
                if (window.contains(0)) {
                    window.remove(0)
                } else {
                    val upperBoundInWindow = (nums.size + window.size) - nums.size
                    window.removeAt(upperBoundInWindow - 1)
                }

                count = max(window.count { it == 1 }, count)
            } else {
                continue
            }

            if (nums[lowerBound] == 0) lowerBound++
            upperBound++
        }

        return count
    }
}
