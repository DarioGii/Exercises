package exercises

class MajorityElement {
    fun majorityElement(nums: IntArray): Int {
        val occurrence = nums.size / 2
        val occurrenceMap = mutableMapOf<Int, Int>()

        for (num in nums) {
            if (occurrenceMap.containsKey(num)) {
                occurrenceMap[num] = occurrenceMap[num]!!.inc()
            } else {
                occurrenceMap[num] = 1
            }
        }

        val filteredMap =
            occurrenceMap
                .filter { it.value > occurrence }
        var majorityElement = 0

        for (entry in filteredMap) {
            if (entry.value > majorityElement) {
                majorityElement = entry.key
            }
        }

        return majorityElement
    }

    // Simpler solution
//    fun majorityElement(nums: IntArray): Int {
//        var cnt = 0
//        var ele = -1
//        nums.indices.forEach { i ->
//            when {
//                cnt == 0 -> {
//                    cnt = 1
//                    ele = nums[i]
//                }
//                nums[i] == ele -> cnt++
//                else -> cnt--
//            }
//        }
//        return ele
//    }
}
