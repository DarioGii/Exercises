package algorithms

class Mergesort {
    fun sort(list: IntArray) {
        val size = list.size

        if (size < 2) return

        val midPoint = size / 2
        val lower = IntArray(midPoint)
        val upper = IntArray(size - midPoint)

        for (i in lower.indices) lower[i] = list[i]
        for (j in midPoint until  list.size) upper[j - midPoint] = list[j]

        sort(lower)
        sort(upper)
        merge(list, lower, upper)
    }

    private fun merge(list: IntArray, lower: IntArray, upper: IntArray) {
        var i = 0
        var j = 0
        var k = 0

        while (i < lower.size && j < upper.size) {
            if (lower[i] <= upper[j]) {
                list[k++] = lower[i++]
            } else {
                list[k++] = upper[j++]
            }
        }

        while (i < lower.size) {
            list[k++] = lower[i++]
        }

        while (j < upper.size) {
            list[k++] = upper[j++]
        }
    }
}