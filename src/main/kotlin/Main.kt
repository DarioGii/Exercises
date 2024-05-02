import kotlinx.coroutines.*
import java.util.concurrent.Executors

suspend fun main(args: Array<String>) {

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Starting program...")
//    To use a pool with multiple threads, i.e. the same as the number of cores use the below line
    Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()).asCoroutineDispatcher().use { context ->
//    Executors.newSingleThreadExecutor().asCoroutineDispatcher().use { context ->
        val coroutineDemo = CoroutineDemo()

        runBlocking {
            withContext(Dispatchers.Default) { coroutineDemo.task1()}
//            launch(context = context, start = CoroutineStart.UNDISPATCHED) { coroutineDemo.task1() }
            launch { coroutineDemo.task2() }

            println("Calling Task 1 & Task 2 from: ${Thread.currentThread()}")
        }

        println("Ending program.")
    }

}