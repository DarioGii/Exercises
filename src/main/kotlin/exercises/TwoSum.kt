package exercises

class TwoSum {
    fun twoSum(
        nums: IntArray,
        target: Int,
    ): IntArray {
        val answer = IntArray(2)

        for (i in nums.indices) {
            for (j in (i + 1..<nums.size)) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i
                    answer[1] = j
                    return answer
                }
            }
        }

        return answer
    }

    /* O(n) solution- one pass with map
     *
     * fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.mapIndexed { index, num ->
            if (target - num in map) return intArrayOf(map.getValue(target - num), index)
            map.put(num, index)
        }
        return IntArray(0)
     * }
     * */
}
