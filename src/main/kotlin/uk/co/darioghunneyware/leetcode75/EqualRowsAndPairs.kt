package uk.co.darioghunneyware.leetcode75

class EqualRowsAndPairs {
    fun equalPairs(grid: Array<IntArray>): Int {
        val rows = mutableMapOf<Int, MutableList<Int>>()
        val columns = mutableMapOf<Int, MutableList<Int>>()

        for (row in grid[0].indices) {
            val rowList = rows.getOrDefault(row, mutableListOf())

            for (column in row until grid.size) {
                rowList.addAll(grid[column].toList())
                break
            }

            rows[row] = rowList
        }

        for (row in grid[0].indices) {
            val colList = columns.getOrDefault(row, mutableListOf())

            for (column in grid.indices) {
                colList.add(grid[column][row])
            }

            columns[row] = colList
        }


        var pairs = 0

        rows.values.forEach { row ->
            pairs += columns.values.count {
                it.equals(row)
            }
        }

        return pairs
    }
}
