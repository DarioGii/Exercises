package uk.co.darioghunneyware.exercises

class SubArrayK {
//    fun subarraySum(nums: IntArray, k: Int): Int {
//        if (nums.size == 1) {
//            return if (nums.first() == k) 1 else 0
//        }
//
//        var count = 0
//
//        for (i in nums.indices) {
//            if (nums[i] == k) {
//                count++
//            }
//
//            for (j in i+1 ..< nums.size) {
//                if (nums[i] + nums[j] == k) {
//                    count++
//                }
//            }
//        }
//
//        return count
//    }

    //    working solution
    // Time: O(n), Space: O(n)
    fun subarraySum(nums: IntArray, k: Int): Int {
        // prefixSum to times
        val cache = hashMapOf<Int, Int>()
        var prefixSum = 0
        var result = 0

        for (num in nums) {
            prefixSum += num
            if (prefixSum == k) result++
            if (prefixSum - k in cache) result += cache[prefixSum - k]!!
            // update the times
            cache[prefixSum] = cache.getOrDefault(prefixSum, 0) + 1
        }

        return result
    }
}