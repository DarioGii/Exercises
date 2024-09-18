package exercises

class SubArraySum {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val subMap = mutableMapOf<Int, Int>()

        for (i in nums.indices.reversed()) {
            for (j in nums.size downTo 1) {
                if (nums[i] == k) {
                    subMap[nums[i]] = 0
                }

                if (nums[i] + nums[j-1] == k) {
                    subMap[nums[i]] = nums[j-1]
                }
            }
        }
        val subIterator = subMap.entries.iterator()

        while (subIterator.hasNext()) {
            val current = subIterator.next()
//            val ssdf = subIterator.

        }

        return subMap.size
    }
}