package uk.co.darioghunneyware.exercises

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size == 3) {
            return if (nums.first() + nums[1] + nums[2] == 0) {
                listOf(nums.toList())
            } else {
                return emptyList()
            }
        }

        nums.sort()
        val threeSumCombos = mutableListOf<List<Int>>()

        for (i in 0..nums.size - 2) {
            var lowerBound = i + 1
            var higherBound = nums.size - 1
            val sum = 0 - nums[i]

            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                while (lowerBound < higherBound) {
                    if (nums[lowerBound] + nums[higherBound] == sum) {
                        threeSumCombos.add(listOf(nums[i], nums[lowerBound], nums[higherBound]))
                        while (lowerBound < higherBound && nums[lowerBound] == nums[lowerBound + 1]) lowerBound++
                        while (lowerBound < higherBound && nums[higherBound] == nums[higherBound - 1]) higherBound--
                        lowerBound++
                        higherBound--
                    } else if (nums[lowerBound] + nums[higherBound] > sum) {
                        higherBound--
                    } else {
                        lowerBound++
                    }
                }
            }
        }

        return threeSumCombos
    }
}
