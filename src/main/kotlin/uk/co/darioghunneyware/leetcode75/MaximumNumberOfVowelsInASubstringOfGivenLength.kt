package uk.co.darioghunneyware.leetcode75

import kotlin.math.max

class MaximumNumberOfVowelsInASubstringOfGivenLength {
    fun maxVowels(
        s: String,
        k: Int,
    ): Int {
        val charArray = s.toCharArray()
        val window = charArray.toMutableList().subList(0, k)
        var count = window.count { isVowel(it) }
        var maxVowels = count

        for (i in k..<s.length) {
            count -= if (isVowel(window.first())) 1 else 0

            window.removeAt(0)
            window.add(charArray[i])

            count += if (isVowel(window.last())) 1 else 0

            maxVowels = max(maxVowels, count)
        }

        return maxVowels
    }

    private fun isVowel(c: Char): Boolean =
        when (c) {
            'a' -> true
            'e' -> true
            'i' -> true
            'o' -> true
            'u' -> true
            else -> false
        }
}
