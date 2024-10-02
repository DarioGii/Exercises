package Leetcode75

class KidsWithCandy {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val mostCandies = mutableListOf<Boolean>()
        val maxCandies = candies.max()

        candies.forEach { candy ->
            val candyPlusExtra = candy + extraCandies

            if (candyPlusExtra >= maxCandies) {
                mostCandies.add(true)
            } else {
                mostCandies.add(false)
            }
        }

        return mostCandies
    }
}