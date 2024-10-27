package uk.co.darioghunneyware.exercises

class Atoi {
    fun myAtoi(s: String): Int {
        if (s.isBlank()) return 0

        var convertedNum = ""
        val sTrimmed = s.trimStart()

        for (char in sTrimmed) {
            when (char) {
                '-' -> {
                    if (char != sTrimmed.first() || convertedNum.isNotBlank()) break
                    else convertedNum += char
                }
                '+' -> if (convertedNum.isNotBlank()) break
                '0' -> if (convertedNum.length > 1 && convertedNum.first() != '-') convertedNum += char
                '1', '2', '3', '4', '5', '6', '7', '8', '9' -> convertedNum += char
                else -> break
            }
        }

        return if (convertedNum.isNotBlank()) convertedNum.toInt() else 0
    }
}