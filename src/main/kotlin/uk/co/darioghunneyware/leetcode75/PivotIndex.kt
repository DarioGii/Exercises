package uk.co.darioghunneyware.leetcode75

/**
 * Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * Example 3:
 *
 * Input: nums = [2,1,-1]
 * Output: 0
 * Explanation:
 * The pivot index is 0.
 * Left sum = 0 (no elements to the left of index 0)
 * Right sum = nums[1] + nums[2] = 1 + -1 = 0
 * */

class PivotIndex {
    fun pivotIndex1(nums: IntArray): Int {
        if (nums.last() + nums[nums.size - 2] == 0) return 0

        val leftSums = mutableListOf(nums.first())
        val rightSums = mutableListOf(nums.last())
        var leftPivotIndex = 1
        var rightPivotIndex = nums.size - 2

        while (leftPivotIndex < nums.size && rightPivotIndex > 0) {
            leftSums.add(nums[leftPivotIndex] + leftSums[leftPivotIndex - 1])
            rightSums.add(nums[rightPivotIndex] + rightSums[leftPivotIndex - 1])

            if (leftSums[leftPivotIndex - 1] == rightSums[rightPivotIndex - (rightPivotIndex - 1)]) return leftPivotIndex

            leftPivotIndex++
            rightPivotIndex--
        }

        return -1
    }

    fun pivotIndex(nums: IntArray): Int {
        val total = nums.sum()
        var leftSum = 0

        for (index in 0 until nums.size) {
            val currentSum = total - leftSum - nums[index]

            if (currentSum == leftSum) return index else leftSum += nums[index]
        }

        return -1
    }
}
