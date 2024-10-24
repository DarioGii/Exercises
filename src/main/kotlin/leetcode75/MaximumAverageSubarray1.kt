package leetcode75

import kotlin.math.max

class MaximumAverageSubarray1 {
    fun findMaxAverage(
        nums: IntArray,
        k: Int,
    ): Double {
        if (nums.isEmpty()) return 0.0
        if (nums.size == k) return nums.average()

        var total =
            nums
                .toList()
                .subList(0, k)
                .sum()
        var maxTotal = total

        for (i in 0 until nums.size - k) {
            total -= nums[i]
            total += nums[i + k]
            maxTotal = max(maxTotal, total)
        }

        return maxTotal / k.toDouble()
    }
}
