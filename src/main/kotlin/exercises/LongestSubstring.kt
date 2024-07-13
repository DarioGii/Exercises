package exercises

import kotlin.math.max

// todo: Sliding window algorithm
class LongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        var end = 0
        var length = 0

        val longestSubstring = hashSetOf<Char>()

        while (end < s.length) {
            if (!longestSubstring.contains(s[end])) {
                longestSubstring.add(s[end])
                end++
                length = max(longestSubstring.size, length)
            } else {
                longestSubstring.remove(s[start])
                start++
            }
        }
        return length
    }
}
