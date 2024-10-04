package Leetcode75

class MoveZeroes {
    fun moveZeroes(nums: IntArray) {
        if (nums.size == 1) return
        if (nums.all { it == 0 }) return

        var count = 0
        var outer = 0
        var temp: Int
        var moved: Boolean

        while (outer < (nums.size - 1) - count) {
            moved = false
            if (nums[outer] == 0) {
                for (inner in outer until nums.size - 1) {
                    temp = nums[inner]
                    nums[inner] = nums[inner + 1]
                    nums[inner + 1] = temp
                }
                moved = true
                count++
            }
            if (!moved) outer++
        }
    }

//    todo: faster solution, worse in terms of space though...
//    fun moveZeroes(nums: IntArray) {
//        var i = 0
//        nums.asSequence().filter { it != 0 }.forEach { nums[i++] = it }
//        nums.fill(0, i)
//    }
}
