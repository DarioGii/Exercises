package uk.co.darioghunneyware.exercises

class FindUniqueAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        if (strs.size == 1) return listOf(listOf(strs.first()))

        val groups: MutableMap<String, MutableList<String>> = mutableMapOf()

        for (word in strs) {
            val sortedWord = word.toCharArray()
                .sorted()
                .joinToString(separator = "")

            if (!groups.containsKey(sortedWord)) {
                groups[sortedWord] = mutableListOf(word)
            } else {
                groups[sortedWord]?.add(word)
            }
        }

        return groups.values.toList()
    }
}