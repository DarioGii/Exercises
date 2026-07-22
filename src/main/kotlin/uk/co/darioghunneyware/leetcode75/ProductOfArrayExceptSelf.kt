package uk.co.darioghunneyware.leetcode75

class ProductOfArrayExceptSelf {
    fun productExceptSelf1(nums: IntArray): IntArray {
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

    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val answer: IntArray = IntArray(n)
        val pre: IntArray = IntArray(n)
        val suff: IntArray = IntArray(n)

        pre[0] = 1
        suff[n - 1] = 1

        for (i in 1..<n) {
            pre[i] = pre[i - 1] * nums[i - 1]
        }
        for (j in n - 2 downTo 0) {
            suff[j] = suff[j + 1] * nums[j + 1]
        }

        for (i in answer.indices) {
            answer[i] = pre[i] * suff[i]
        }

        return answer
    }
}
