package leetcode75

class ReverseVowelsOfAString {
    fun reverseVowels(s: String): String {
        if (s.length == 1) return s

        var text = s
        val vowels = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val foundVowels = mutableListOf<Char>()
        var vowelPos = mutableListOf<Int>()

        for ((index, letter) in text.withIndex()) {
            if (letter in vowels) {
                foundVowels.add(letter)
                vowelPos.add(index)
            }
        }

        vowelPos = vowelPos.reversed().toMutableList()
        var sArray = s.toCharArray()

        for (i in 0..<foundVowels.size) {
            sArray[vowelPos[i]] = foundVowels[i]
        }

        return sArray.concatToString()
    }

    // functional solution
//    fun reverseVowels(s: String) = with(s.filter { it.isVowel }.reversed()) {
//        var vowel = 0
//        s.map { it.takeUnless { it.isVowel } ?: get(vowel++) }.joinToString("")
//    }
//    private val Char.isVowel get() = when(lowercaseChar()) { 'a', 'e', 'i', 'o', 'u' -> true else -> false }
}
