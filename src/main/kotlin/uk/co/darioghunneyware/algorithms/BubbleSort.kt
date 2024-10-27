package uk.co.darioghunneyware.algorithms

class BubbleSort {
    fun sortAscending(list: IntArray): IntArray {
        var temp = 0

        for (i in list.indices) {
            for (j in 0 until (list.size - 1) - i) {
                if (list[j] >= list[j + 1]) {
                    temp = list[j]
                    list[j] = list[j+1]
                    list[j+1] = temp
                }
            }
        }

        return list
    }

    fun sortDescending(list: IntArray): IntArray {
        var temp = 0

        for (i in list.indices) {
            for (j in 0 until (list.size - 1) - i) {
                if (list[j] <= list[j + 1]) {
                    temp = list[j]
                    list[j] = list[j+1]
                    list[j+1] = temp
                }
            }
        }

        return list
    }
}