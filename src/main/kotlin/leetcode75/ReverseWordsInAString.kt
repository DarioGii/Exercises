package leetcode75

class ReverseWordsInAString {
    fun reverseWords(s: String): String {
        val text =
            s
                .trim()
                .split(" ")
                .filterNot { it == "" }

        if (text.size == 1) return text.first()

        return text.reversed().joinToString(separator = " ")
    }
}
