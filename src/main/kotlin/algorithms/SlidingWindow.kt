package algorithms

import kotlin.math.max

class SlidingWindow {
    fun bruteForce(array: IntArray, k: Int): Int {
        var maxTotal = 0

        for (i in 0 ..< (array.size - k) + 1) {
            var total = array.toList()
                .subList(i, i+k)
                .sum()
            maxTotal = max(maxTotal, total)
        }

        return maxTotal
    }

    fun efficient(array: IntArray, k: Int): Int {
        if (array.isEmpty()) return 0

        var total = array.toList().subList(0, k)
            .sum()
        var maxTotal = total

        for (i in 0 ..< array.size - k) {
            total -= array[i]
            total += array[i+k]
            maxTotal = max(maxTotal, total)
        }

        return maxTotal
    }
}