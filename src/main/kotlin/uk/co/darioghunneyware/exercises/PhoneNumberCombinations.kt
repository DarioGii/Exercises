package uk.co.darioghunneyware.exercises

class PhoneNumberCombinations {
    private val keyPad = mapOf(
        '2' to listOf("a", "b", "c"),
        '3' to listOf("d", "e", "f"),
        '4' to listOf("g", "h", "i"),
        '5' to listOf("j", "k", "l"),
        '6' to listOf("m", "n", "o"),
        '7' to listOf("p", "q", "r", "s"),
        '8' to listOf("t", "u", "v"),
        '9' to listOf("w", "x", "y", "z")
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isBlank()) return emptyList()

        val buttons = mutableListOf<List<String>>()
        val letterCombinations = mutableListOf<String>()

        for (digit in digits) {
            buttons.add(keyPad[digit]!!)
        }


        return letterCombinations
    }
}