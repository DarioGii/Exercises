package uk.co.darioghunneyware.leetcode75

import kotlin.math.max

class MaxVowelsInSubstring {
    fun maxVowels(
        s: String,
        k: Int,
    ): Int {
        var count = 0

        for (i in 0 until k) {
            if (isVowel(s[i])) {
                count++
            }
        }

        var maxVowels = count

        for (i in k until s.length) {
            count -= if (isVowel(s[i - k])) 1 else 0
            count += if (isVowel(s[i])) 1 else 0
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
