package leetcode75

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

//        fixme: compare two maps

        val pairs =
            rows.values.reduce { row ->
                return columns.values.count {
                    row.containsAll(it)
                }
            }

        return rowPairs.count { colPairs.containsAll(colPairs) }
    }
}
