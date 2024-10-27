package uk.co.darioghunneyware.leetcode75

class MaxKSumPairs {
    fun maxOperations(
        nums: IntArray,
        k: Int,
    ): Int {
        when {
            nums.size == 1 && nums.first() == k -> return 1
            nums.size == 1 && nums.first() != k -> return 0
        }

        nums.sort()
        val filteredNums = nums.filterNot { it >= k }.toMutableList()

        var operations = 0
        var i = 0
        var j = i + 1

        while (i < filteredNums.size) {
            if (filteredNums[i] == -1) {
                i++
                continue
            }

            while (j < filteredNums.size) {
                if (i == j || filteredNums[j] == -1) {
                    j++
                    continue
                }

                if (filteredNums[i] + filteredNums[j] == k) {
                    filteredNums[i] = -1
                    filteredNums[j] = -1
                    i++
                    j = i + 1
                    operations++
                    continue
                }
                j++
            }
            i++
            j = i + 1
        }

        return operations
    }
}
