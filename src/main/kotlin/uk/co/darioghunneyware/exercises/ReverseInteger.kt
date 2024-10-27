package uk.co.darioghunneyware.exercises

class ReverseInteger {
    fun reverse(x: Int): Int {
        return try {
            if (x < 0) {
                val y = 0 - x
                val yReversed = y.toString().reversed().toInt()
                0 - yReversed
            } else {
                x.toString().reversed().toInt()
            }
        } catch (nfe: NumberFormatException) {
            0
        }
    }
}
