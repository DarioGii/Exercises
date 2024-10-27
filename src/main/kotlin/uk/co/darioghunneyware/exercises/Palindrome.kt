package uk.co.darioghunneyware.exercises

class Palindrome {
    fun isPalindrome(s: String): Boolean {
        if (s.length == 1) return true

        val nonAlphaNumericRegex = Regex("[^a-zA-Z\\d]")
        val word = s.replace(nonAlphaNumericRegex, "")

        if (word.length <= 1) return true

        if (word.length % 2 == 0) {
            val midPoint = word.length / 2
            val firstHalf = word.substring(0, midPoint).lowercase()
            val secondHalf = word.substring(midPoint).lowercase().reversed()

            return firstHalf == secondHalf
        } else {
            val midPoint = word.length / 2
            val firstHalf = word.substring(0..midPoint).lowercase()
            val secondHalf = word.substring(midPoint).lowercase().reversed()

            return firstHalf == secondHalf
        }
    }
}
