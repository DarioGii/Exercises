import kotlinx.coroutines.yield

class CoroutineDemo {

suspend fun task1() {
    println("Start of Task 1 in: ${Thread.currentThread()}")
    yield()
    println("End of Task 1 in: ${Thread.currentThread()}")
}
suspend fun task2() {
    println("Start of Task 2 in: ${Thread.currentThread()}")
    yield()
    println("End of Task 2 in: ${Thread.currentThread()}")
}
}
