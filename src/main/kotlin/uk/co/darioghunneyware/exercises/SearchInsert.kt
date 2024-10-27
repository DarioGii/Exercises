package uk.co.darioghunneyware.exercises

class SearchInsert {
    fun searchInsert(
        nums: IntArray,
        target: Int,
    ): Int {
        if (nums.size == 1) {
            return if (target <= nums.first()) {
                0
            } else {
                nums.size
            }
        }

        for ((index, num) in nums.withIndex()) {
            if (num == target) return index
        }

        for (index in 1 until nums.size) {
            if (target <= nums[index - 1]) return index - 1
            if (target >= nums[index - 1] && target <= nums[index]) return index
        }
        return nums.size
    }
}
