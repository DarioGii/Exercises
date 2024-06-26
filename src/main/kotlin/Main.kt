import demo.CoroutineDemo
import demo.LambdaExpressions
import demo.SequenceDemo
import demo.iterator
import exercises.AddTwoNumbers
import exercises.Cycle
import exercises.RemoveDuplicates
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import model.ListNode
import java.util.concurrent.Executors

suspend fun main(args: Array<String>) {
//    coroutinesDemo()
//    sequencesDemo()
//    lambdaDemo()
    val cycles = Cycle()
    val addTwoNumbers = AddTwoNumbers()
    val l1 = ListNode(3)
    l1.next = ListNode(2)
    l1.next?.next = ListNode(0)
    l1.next?.next?.next = ListNode(-4)
    l1.next?.next?.next?.next = l1.next
//    l1.next?.next?.next = ListNode(0)
//    l1.next?.next?.next?.next = ListNode(1)
//    l1.next?.next?.next?.next?.next = ListNode(9)
//    l1.next?.next?.next?.next?.next?.next = ListNode(0)
//    l1.next?.next?.next?.next?.next?.next?.next = ListNode(1)
//    l1.next?.next?.next?.next?.next?.next?.next?.next = ListNode(6)
//    l1.next?.next?.next?.next?.next?.next?.next?.next?.next = ListNode(1)
    val l2 = ListNode(5)
    l2.next = ListNode(5)
    l2.next?.next = ListNode(8)
//    l2.next?.next?.next = ListNode(6)
//    l2.next?.next?.next?.next = ListNode(2)
//    l2.next?.next?.next?.next?.next = ListNode(5)
//    l2.next?.next?.next?.next?.next?.next = ListNode(8)
//    l2.next?.next?.next?.next?.next?.next?.next = ListNode(2)
//    l2.next?.next?.next?.next?.next?.next?.next?.next = ListNode(6)
//    l2.next?.next?.next?.next?.next?.next?.next?.next?.next = ListNode(1)
//    printList(addTwoNumbers.addTwoNumbers(l1, l2))
    println(cycles.detectCycle(l1))

}

fun mergeTwoSortedLists(
    list1: ListNode?,
    list2: ListNode?,
): ListNode? {
    val result = ListNode(0)
    var current = result

    var node1 = list1
    var node2 = list2

    while (node1 != null || node2 != null) {
        if (node1 == null) {
            current.next = node2
            break
        }
        if (node2 == null) {
            current.next = node1
            break
        }

        if (node1.`val` < node2.`val`) {
            current.next = node1
            node1 = node1.next
        } else {
            current.next = node2
            node2 = node2.next
        }

        current = current.next!!
    }
    return result.next
}

fun traverseLinkedList(list1: ListNode?) {
    if (list1 == null) return

    println(list1.`val`)

    traverseLinkedList(list1.next)
}

fun removeElement(
    nums: IntArray,
    `val`: Int,
): Int {
    var count = 0

//    nums.forEach { if (it == `val`) count++ }
//    val filteredNums = nums.filter { it != `val` }

    for (i in nums.indices) {
        if (nums[i] != `val`) {
            nums[count++] = nums[i]
        }
    }

    return count
}
//
// fun longestCommonPrefix(strs: Array<String>): String {
//    if (strs.isEmpty()) return ""
//    if (strs.size == 1 && strs.first().isBlank()) return ""
//
//    val firstWord = strs.first()
//    val prefixes: MutableList<Pair<String, Int>> = mutableListOf()
//
//    for (index in 1..firstWord.length) {
//        var prefix = firstWord.substring(0, index)
//        var count = 0
//        strs[0].commonPrefixWith()
//
//        for (word in strs) {
//            if (prefix in word) {
//                count++
//            }
//        }
//
//        prefixes.add(prefix to count)
//    }
//
//    if (prefixes.all { it.second < 1 }) {
//        return ""
//    }
//
//    return findLongestCommonPrefix(prefixes)
// }

private fun findLongestCommonPrefix(prefixes: List<Pair<String, Int>>): String {
    var longestPrefix: Pair<String, Int> = Pair("", 0)

    prefixes.forEach {
        if (it.first.length > longestPrefix.first.length && it.second >= longestPrefix.second) longestPrefix = it
    }

    return longestPrefix.first
}

private fun printList(node: ListNode?) {
    var current = node
    while (current != null) {
        print(current.`val`)
        if (current.next != null) {
            print(" -> ")
        }
        current = current.next
    }
    println()
}

fun lambdaDemo() {
    val lambdaExpressions = LambdaExpressions()

//    lambdaExpressions.walk1To(5) { println(it) } // <- function call using lambda
//    lambdaExpressions.walk1To(7, ::println) // <- function call using function reference

    val names = listOf("Stella", "Charles", "Dario", "Sam", "Michelle", "Hayat")
    println(names.find(lambdaExpressions.predicateOfLength(5)))
}

fun sequencesDemo() {
    for (word in "hell".."help") {
        print("$word, ")
    }
    val sequenceDemo = SequenceDemo()

    for (prime in sequenceDemo.primes(5)) {
        println("Received $prime")
        if (prime > 30) break
    }
}

suspend fun coroutinesDemo() {
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
