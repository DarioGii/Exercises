import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

suspend fun main(args: Array<String>) {
//    coroutinesDemo()
//    sequencesDemo()
//    lambdaDemo()
//    val strings: Array<String> = arrayOf("flower", "flow", "flight")
//    val strings: Array<String> = arrayOf("dog", "racecar", "car")
//    val strings: Array<String> = arrayOf("aaa", "aa", "aaa")
//    val strings: Array<String> = arrayOf("c", "acc", "ccc")
//    val strings: Array<String> = arrayOf("c")
//    println(longestCommonPrefix(strings))
//    val dupes = RemoveDuplicates()
//    val nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
//    println(dupes.removeDuplicates(nums))
//    val needleHaystack = NeedleHaystack()
//    val searchInsert = SearchInsert()
//    val l1 = intArrayOf(1)
//    println(searchInsert.searchInsert(l1, 0))
    val lastWord = LastWord()
    println(lastWord.lengthOfLastWord("   fly me   to   the moon  "))

//    println(needleHaystack.strStr("sadbuttsad", "sad"))
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
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
    if (list1 == null) {
        return
    }

    println(list1.`val`)

    traverseLinkedList(list1.next)
}

fun reverseLinkedList(list1: ListNode?): ListNode? {
    if (list1 == null) {
        return null
    }

    val temp = ListNode(list1.`val`)
    temp.next = reverseLinkedList(list1.next)

    return temp
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
