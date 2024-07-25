package exercises

class MedianArrays {
    fun findMedianSortedArrays(
        nums1: IntArray,
        nums2: IntArray,
    ): Double {
        val mergeSortedArray = intArrayOf(*nums1, *nums2).sorted()
        val midpoint = mergeSortedArray.size / 2

        return if (mergeSortedArray.size % 2 != 0) {
            mergeSortedArray[midpoint].toDouble()
        } else {
            ((mergeSortedArray[midpoint] + mergeSortedArray[midpoint - 1]).toDouble() / 2)
        }
    }
}
