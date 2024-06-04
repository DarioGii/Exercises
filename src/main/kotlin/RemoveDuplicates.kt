class RemoveDuplicates {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size == 1) return 1

        val occurrenceMap: MutableMap<Int, Int> = mutableMapOf()

        for (num in nums) {
            var currentNum = num

            for (index in 1..<nums.size) {
                if (nums[index - 1] == currentNum) {
                    if (occurrenceMap.containsKey(currentNum)) {
                        if (occurrenceMap[currentNum]!! >= 1) {
                            nums[index - 1] = 101
                        }
                    } else {
                        occurrenceMap[currentNum] = 1
                    }
                }
            }
        }

        nums.sort()
        return nums.count { it != 101 }
    }
}
