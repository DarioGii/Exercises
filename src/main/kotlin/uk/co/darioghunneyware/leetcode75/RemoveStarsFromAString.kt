package uk.co.darioghunneyware.leetcode75

class RemoveStarsFromAString {
    fun removeStars(s: String): String {
        if (s.length == 1) {
            if (s.first() != '*') return s
        }
        if (s.length == 2) {
            if (s.contains('*')) return ""
        }
        if (!s.contains('*')) return s

        var sIndex = 0
        var index = 0
        var pruned = ""

        while (sIndex < s.length) {
            if (s[sIndex] != '*') {
                pruned += s[sIndex]
                index++
            } else {
                pruned = pruned.removeRange(index - 1, index--)
            }
            sIndex++
        }

        return pruned
    }
}
