package exercises

import java.util.regex.Pattern

class NeedleHaystack {
    fun strStr(
        haystack: String,
        needle: String,
    ): Int {
        val matcher =
            Pattern
                .compile(Pattern.quote(needle), Pattern.CASE_INSENSITIVE)
                .matcher(haystack)
        val found = matcher.find()

        if (!found) return -1

        return matcher.start()
    }
}
