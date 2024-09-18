package exercises

import kotlin.math.max

class MergeSortedArray {
    fun merge(
        nums1: IntArray,
        m: Int,
        nums2: IntArray,
        n: Int,
    ) {
        if (m == 0 && nums2.size == 1) {
            nums1[0] = nums2.first()
            return
        }
        if (m == 1 && n == 0) return

        var pointer = (m + n) - 1
        var pointer1 = m - 1
        var pointer2 = n - 1

        while (pointer1 >= 0 && pointer2 >= 0) {
            if (nums2[pointer2] > nums1[pointer1]) {
                nums1[pointer] = nums2[pointer2]
                pointer--
                pointer2--
            } else {
                nums1[pointer] = nums1[pointer1]
                pointer--
                pointer1--
            }
        }

        while (pointer2 >= 0) {
            nums1[pointer] = nums2[pointer2]
            pointer2--
            pointer--
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
