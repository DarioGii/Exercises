package uk.co.darioghunneyware.leetcode75

/**
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 * */

class UniqueNumberOfOccurrences {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        if (arr.size == 1) return true

        arr.sort()
        val occurrences = mutableListOf<Int>()
        occurrences.add(arr.count { it == arr.first() })

        for (index in 1 until arr.size) {
            var occurredBefore = false
            val previousNumber = arr[index - 1]
            val currentNumber = arr[index]

            if (previousNumber == currentNumber) occurredBefore = true

            if (occurredBefore) continue

            occurrences.add(arr.count { it == currentNumber })
        }

        return occurrences.distinct() == occurrences
    }
}
