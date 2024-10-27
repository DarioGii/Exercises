package uk.co.darioghunneyware.exercises

class Fibonacci {
    fun fib(n: Int): Int =
        if (n < 2) {
            n
        } else {
            fib(n - 1) + fib(n - 2)
        }

    fun fibIteration(n: Int): Int {
        var a = 0
        var b = 1
        var tmp: Int

        for (i in 2..n) {
            tmp = a + b
            a = b
            b = tmp
        }
        return b
    }
}
