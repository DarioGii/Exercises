package uk.co.darioghunneyware.exercises

class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        if (s.length == 1) {
            return s
        }

        val palindromicSubstrings = mutableSetOf<String>()

        for (outerIndex in s.indices) {
            for (innerIndex in (outerIndex + 1) ..< s.length) {
                val substring = s.substring(outerIndex, innerIndex + 1)

                if (substring == substring.reversed()) {
                    palindromicSubstrings.add(substring)
                }
            }
        }

        return if (palindromicSubstrings.isNotEmpty()) {
            palindromicSubstrings.maxBy { it.length }
        } else {
            s.first().toString()
        }
    }
}