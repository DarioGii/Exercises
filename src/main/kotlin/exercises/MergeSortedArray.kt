package exercises

class MergeSortedArray {
    fun merge(
        nums1: IntArray,
        m: Int,
        nums2: IntArray,
        n: Int,
    ) {
        if (n == 0 && m == 1) {
            return
        } else if (m == 0 && n == 1) {
            nums1[0] = nums2.first()
            return
        }

        val sortedNums: IntArray = IntArray(m + n)
        var nums2Pos = 0

        for ((index, num1Val) in nums1.withIndex()) {
            if (num1Val == 0) {
                break
            }

            for ((index1, num2Val) in nums2.withIndex()) {
                if (num1Val <= num2Val) {
                    sortedNums[index] = num1Val
                } else {
                    sortedNums[index] = num2Val
                    nums2Pos++
                }
            }
        }

        val unfilledStartPos = sortedNums.indexOf(0)

        if (unfilledStartPos != -1) {
            for (i in unfilledStartPos..sortedNums.size) {
                for (j in nums2Pos..nums2.size) {
                    sortedNums[i] = nums2[j]
                }
            }
        }

        for ((index, i) in sortedNums.withIndex()) {
            nums1[index] = i
        }
    }

//    fixMe: Working solution
//    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
//        var a1 = m - 1  // Pointer for the last element in the initial part of nums1
//        var a2 = n - 1  // Pointer for the last element in nums2
//
//        for (i in nums1.size - 1 downTo 0) {
//            if (a1 >= 0 && (a2 < 0 || nums1[a1] >= nums2[a2])) {
//                nums1[i] = nums1[a1]  // Place element from nums1
//                a1--
//            } else {
//                nums1[i] = nums2[a2]  // Place element from nums2
//                a2--
//            }
//        }
//    }
}
