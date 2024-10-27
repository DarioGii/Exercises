package uk.co.darioghunneyware.exercises

class BuySellStock {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size == 1) {
            return 0
        }

        val combos = mutableListOf<Int>()

        for (index in prices.indices) {
            combos.add(findSell(index, prices))
        }

        return if (combos.all { it <= 0 }) {
            0
        } else {
            combos.filter { it > 0 }.max()
        }
    }

    private fun findSell(
        index: Int,
        prices: IntArray,
    ): Int {
        var sell: Int = Int.MIN_VALUE

        for (i in index.inc()..<prices.size) {
            if (prices[i] > sell) {
                sell = prices[i]
            }
        }

        return if (prices.contains(sell)) {
            sell - prices[index]
        } else {
            -1
        }
    }
}
