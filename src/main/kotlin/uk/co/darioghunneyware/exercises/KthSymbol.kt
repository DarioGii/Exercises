package uk.co.darioghunneyware.exercises

class KthSymbol {
    fun kthGrammar(
        n: Int,
        k: Int,
    ): Int {
        if (n == 1) return 0

        val parent = kthGrammar(n - 1, (k + 1) / 2)

        return if (k % 2 == 0) {
            if (parent == 0) {
                0
            } else {
                1
            }
        } else {
            parent
        }
    }
}
