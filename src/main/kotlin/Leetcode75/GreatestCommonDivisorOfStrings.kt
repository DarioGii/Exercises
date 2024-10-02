package Leetcode75

class GreatestCommonDivisorOfStrings {
    fun gcdOfStrings(str1: String, str2: String): String {
        var gcdString = ""
        val shorter = if (str1.length < str2.length) str1 else str2
        val longer = if (shorter == str1) str2 else str1
        var index = 0
        var divisible: Boolean

        while (index < shorter.length) {
            divisible = true
            val current = shorter.substring(0, index + 1)

            for (i in 0 until longer.length step current.length) {
                if (i + current.length > longer.length) {
                    divisible = false
                    break
                }

                if (longer.substring(i, current.length + i) == current) {
                    continue
                } else {
                    divisible = false
                    break
                }
            }

            if (divisible) gcdString = current

            index++
        }

        return gcdString
    }
}