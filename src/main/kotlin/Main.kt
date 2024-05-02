import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

suspend fun main(args: Array<String>) {
//    coroutinesDemo()
    sequencesDemo()
}

fun sequencesDemo() {
    val sequenceDemo = SequenceDemo()

    for (prime in sequenceDemo.primes(5)) {
        println("Received $prime")
        if (prime > 30) break
    }
}

private fun coroutinesDemo() {
    println("Starting Coroutines program...")
//    To use a pool with multiple threads, i.e. the same as the number of cores use the below line
//    Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()).asCoroutineDispatcher().use { context ->
    Executors.newSingleThreadExecutor().asCoroutineDispatcher().use {
        val coroutineDemo = CoroutineDemo()

        runBlocking(CoroutineName("Dario Coroutine")) {
            val count: Deferred<Int> =
                async(CoroutineName("Dario Task")) {
                    println("Fetching in: ${Thread.currentThread()}")
                    Runtime.getRuntime().availableProcessors()
                }
            println("Number of cores: ${count.await()}")
        }

        println("Ending program.")
    }
}
