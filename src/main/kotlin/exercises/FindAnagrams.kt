package exercises

class FindAnagrams {
    fun anagram(strings: List<String>): List<String> {
        val anagramMap = mutableMapOf<String, String>()

        for (string in strings) {
            val sortedChars = string.toCharArray().sorted().joinToString(separator = "")

            if (!anagramMap.containsKey(sortedChars)) {
                anagramMap[sortedChars] = string
            }
        }

        return anagramMap.values.toList()
    }
}
