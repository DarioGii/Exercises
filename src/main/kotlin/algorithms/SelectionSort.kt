package algorithms

class SelectionSort {
    fun sortAscending(list: IntArray): IntArray {
        for (i in list.indices) {
            var minIndex = i

            for (j in (i + 1) until list.size) {
                if (list[j] < list[minIndex]) {
                    minIndex = j
                }
            }

            val temp = list[minIndex]
            list[minIndex] = list[i]
            list[i] = temp
        }

        return list
    }
}