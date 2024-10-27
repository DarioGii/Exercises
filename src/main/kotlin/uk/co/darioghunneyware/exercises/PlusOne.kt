package uk.co.darioghunneyware.exercises

class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        var numStr = ""

        for (digit in digits) {
            numStr += digit
        }

        try {
            numStr = numStr
                .toInt()
                .inc()
                .toString()
        } catch (e: NumberFormatException) {
            numStr = numStr
                .toBigInteger()
                .inc()
                .toString()
        }

        val digitsPlusOne = IntArray(numStr.length)

        for ((index, digit) in numStr.withIndex()) {
            digitsPlusOne[index] = digit.digitToInt()
        }

        return digitsPlusOne
    }
}