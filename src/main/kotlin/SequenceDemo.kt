class SequenceDemo {
    fun primes(start: Int): Sequence<Int> {
        return sequence<Int> {
            println("Starting to look...")

            var index = start

            while (true) {
                if (index > 1 && (2 until index).none { i -> index % i == 0 }) {
                    yield(index)
                    println("Generating next after $index...")
                }
                index++
            }
        }
    }
}
