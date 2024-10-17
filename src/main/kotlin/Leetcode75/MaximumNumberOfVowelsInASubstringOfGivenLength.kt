package Leetcode75

class MaximumNumberOfVowelsInASubstringOfGivenLength {
    fun maxVowels(s: String, k: Int): Int {
        var window: String
        var maxVowels = 0

        for (i in 0 .. (s.length - k)) {
            window = s.substring(i..(i+k)-1)
            val count = window.count { isVowel(it) }

            if (count >= maxVowels) {
                maxVowels = count
            }
        }

        return maxVowels
    }

    fun isVowel(c: Char): Boolean {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
    }
}