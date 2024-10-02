package Leetcode75

class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        if (nums.all { it == 0 }) {
            return IntArray(nums.size)
        }

        val answer = IntArray(nums.size) { 1 }

        for (i in nums.indices) {
            val currentNum = nums[i]
            val currentNumPos = i

            for (j in nums.indices) {
                if (nums[j] != currentNum && j != currentNumPos) {
                    answer[i] *= nums[j]
                }
            }
        }

//        for ((outer, currentNum) in nums.withIndex()) {
//            var product = if (outer == 0) nums[outer+1] else nums.first()
//
//            for (inner in 1 ..< nums.size) {
//                if (nums[inner] != currentNum) {
//                    product *= nums[inner]
//                }
//            }
//
//            answer[outer] = product
//        }

        return answer
    }
}