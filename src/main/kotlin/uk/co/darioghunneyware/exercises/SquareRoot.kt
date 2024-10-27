package uk.co.darioghunneyware.exercises

import java.math.BigDecimal

class SquareRoot {
    fun mySqrt(x: Int): Int {
        var left: BigDecimal = BigDecimal.ZERO
        var right: BigDecimal = x.toBigDecimal()
        var result: BigDecimal = BigDecimal.ZERO

        while (left <= right) {
            var midPoint: BigDecimal = (left + right) / BigDecimal.valueOf(2)

            if (midPoint*midPoint > x.toBigDecimal()) {
                right = midPoint - BigDecimal.ONE
            } else if (midPoint*midPoint < x.toBigDecimal()) {
                left = midPoint + BigDecimal.ONE
                result = midPoint
            } else {
                return midPoint.toInt()
            }
        }

        return result.toInt()
    }
}