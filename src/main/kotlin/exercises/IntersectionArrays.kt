package exercises

class IntersectionArrays {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val intersection = mutableSetOf<Int>()

        val smaller = if (nums1.size < nums2.size)
            nums1
        else if (nums1.size > nums2.size)
            nums2
        else
            nums1

        val larger = if (smaller.size == nums1.size) nums2 else nums1

        for (outer in smaller) {
            var currentNum = outer

            for (inner in larger) {
                if (currentNum == inner) {
                    intersection.add(currentNum)
                    break
                }
            }
        }
        return intersection.toIntArray()
    }

    // simpler solution
//    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
//        val unique1 = nums1.toSet()
//        val unique2 = nums2.toSet()
//        return unique1.intersect(unique2).toIntArray()
//    }
}