package uk.co.darioghunneyware.exercises

class FirstUniqueChar {
    fun firstUniqChar(s: String): Int {
        if (s.length == 1) {
            return 0
        }

        val strlist = s.toCharArray()

        for ((index, currentCharacter) in strlist.withIndex()) {
            for (i in s.indices) {
                if (currentCharacter == s[i]) {
                    if (index == i && i == s.length - 1)  else break
                }
                if (i == s.length - 1) {
                    return index
                }
            }
        }

        return -1
    }
}