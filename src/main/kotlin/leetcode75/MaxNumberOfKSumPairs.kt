package leetcode75

class MaxNumberOfKSumPairs {
    fun maxOperations(
        nums: IntArray,
        k: Int,
    ): Int {
        if (nums.size == 1 && nums.first() == k) return 1
        if (nums.size == 1 && nums.first() != k) return 0

        var operations = 0
        var i = 0
        var j = i + 1

        while (i < nums.size) {
            if (nums[i] == -1) i++

            while (j < nums.size) {
                if (nums[i] + nums[j] == k) {
                    nums[i] = -1
                    nums[j] = -1
                    operations++
                }
                j++
            }
            i++
            j = i + 1
        }

        return operations
    }
}
