package exercises

class LastWord {
    fun lengthOfLastWord(s: String): Int {
        val regex = Regex("\\s+")
        val words = s.trim().split(regex)

        return words.last().length
    }
}
