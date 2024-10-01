package exercises

class PowX {
    fun myPow(
        x: Double,
        n: Int,
    ): Double {
        when {
            x == 0.0 -> return 0.0
            n.toDouble() == 0.0 -> return 1.0
            n == 1 -> return 0.0
        }

        return if (n > 0) calculatePower(x, n) else calculateNegativePower(x, n)
    }

    private fun calculatePower(
        x: Double,
        n: Int,
    ): Double {
        if (n == 0) {
            return 1.0
        }

        return x * calculatePower(x, n - 1)
    }

    private fun calculateNegativePower(
        x: Double,
        n: Int,
    ): Double {
        if (n == 0) {
            return 1.0
        }

        return (1 / x) * calculateNegativePower(x, n + 1)
    }
}
