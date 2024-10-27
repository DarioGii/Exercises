package uk.co.darioghunneyware.exercises

class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        return if (nums.size == 1) {
            false
        } else {
            val uniqueNums: Set<Int> = nums.toSet()

            return uniqueNums.size != nums.size
        }
    }
}
