package algorithms

class Quicksort {
    fun sort(list: IntArray, left: Int = 0, right: Int = list.size - 1): IntArray {
        var start = left
        var end = right
        val pivot = list[(left + right) / 2]

        while (start <= end) {
            while (list[start] < pivot) {
                start++
            }
            while (list[end] > pivot) {
                end--
            }
            if (start <= end) {
                val temp = list[start]
                list[start] = list[end]
                list[end] = temp
                start++
                end--
            }
        }

        if (left < end) {
            sort(list, left, end)
        }
        if (start < right) {
            sort(list, start, right)
        }
        return list
    }
}