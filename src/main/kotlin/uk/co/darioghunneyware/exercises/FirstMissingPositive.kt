package uk.co.darioghunneyware.exercises

class FirstMissingPositive {
    fun firstMissingPositive(nums: IntArray): Int {
        nums.sort()

        if (nums.first() == 2 && (!nums.contains(1))) {
            return 1
        }

        // iterate between the first two numbers and return the smallest number
        // that's not in the list

        return nums[nums.size-1] + 1
    }
}