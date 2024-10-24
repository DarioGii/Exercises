package leetcode75

class IncreasingTripletSubsequence {
    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3) return false

        if (nums.size == 3) {
            return nums.first() < nums[1] && nums[1] < nums[2]
        }

        var i = 0

        var triplet = false

        while (i < nums.size) {
            var j = i + 1

            while (j < nums.size) {
                if (nums[j] > nums[i]) {
                    var k = j + 1

                    while (k < nums.size) {
                        if (nums[k] > nums[j]) {
                            triplet = true
                            break
                        }
                        k++
                    }
                }

                if (triplet) break else j++
            }
            if (triplet) break else i++
        }

        return triplet
    }

//    toDo: better solution
// fun increasingTriplet(nums: IntArray): Boolean {
//    var target = Int.MAX_VALUE
//    var min = Int.MAX_VALUE
//    for (n in nums) {
//        if (n > target) return true
//        if (n > min) target = n
//        if (n < min) min = n
//    }
//    return false
// }
}
