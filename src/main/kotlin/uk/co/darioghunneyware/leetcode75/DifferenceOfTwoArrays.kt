package uk.co.darioghunneyware.leetcode75

class DifferenceOfTwoArrays {
    fun findDifference(
        nums1: IntArray,
        nums2: IntArray,
    ): List<List<Int>> {
        val answer1 = nums1.subtract(nums2.toSet())
        val answer2 = nums2.subtract(nums1.toSet())

        return listOf(answer1.toList(), answer2.toList())
    }
}
