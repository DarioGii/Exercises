package exercises

class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        if (nums.size == 1) return nums.first()

        nums.sort()

        var currentNum = nums.first()
        var count = 1

        for (i in 1..<nums.size) {
            if (currentNum == nums[i]) {
                count++
            } else {
                if (count != 2) {
                    return currentNum
                }
                currentNum = nums[i]
                count = 1
            }
        }
        return currentNum
    }
}
