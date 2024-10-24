package leetcode75

class CanPlaceFlowers {
    fun canPlaceFlowers(
        flowerbed: IntArray,
        n: Int,
    ): Boolean {
        if (n == 0) return true

        if (flowerbed.size == 1) {
            return if (flowerbed.first() == 0) true else false
        }

        var flowers = n
        var index = 1

        if (flowerbed.first() == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1
            flowers--
        }

        while (index < flowerbed.size) {
            if (flowers <= 0) break

            if (index == flowerbed.size - 2) {
                if (flowerbed[index] == 0 && flowerbed[index + 1] == 0) {
                    flowerbed[index] = 1
                    flowers--
                }
            }

            if (flowerbed[index - 1] == 0 && flowerbed[index] == 0 && flowerbed[index + 1] == 0) {
                flowerbed[index] = 1
                flowers--
            }

            index++
        }

        return flowers == 0
    }
}
