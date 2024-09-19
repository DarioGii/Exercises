package exercises

class FirstLastPos {
    fun searchRange(
        nums: IntArray,
        target: Int,
    ): IntArray {
        val positions = IntArray(2)

        if (nums.size == 1) {
            return if (nums.first() == target) {
                positions
            } else {
                intArrayOf(-1, -1)
            }
        }
        var numIndex = 0
        var posIndex = 0

        while (numIndex < nums.size) {
            if (nums[numIndex] == target) {
                positions[posIndex] = numIndex
                posIndex++
            }

            if (positions.first() != 0 && positions.last() != 0) break

            numIndex++
        }

        return if (positions.first() == 0 && positions.last() == 0) intArrayOf(-1, -1) else positions
    }
}
