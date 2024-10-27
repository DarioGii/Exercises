package uk.co.darioghunneyware.leetcode75

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 *
 * Output: 6
 *
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 *
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 *
 * Output: 10
 *
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 *
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * */

class MaxConsecutiveOnes3 {
    fun longestOnes(
        nums: IntArray,
        k: Int,
    ): Int {
        if (nums.size == 1) {
            if (k >= 1) return 1
        }

        var kCopy = k
        var lowerBound = 0
        var upperBound = 0

        while (lowerBound < nums.size) {
            if (nums[lowerBound] == 0) kCopy--
            if (kCopy < 0) {
                if (nums[upperBound] == 0) kCopy++
                upperBound++
            }
            lowerBound++
        }

        return lowerBound - upperBound
    }
}
