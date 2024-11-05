package uk.co.darioghunneyware.leetcode75

import java.util.LinkedList
import java.util.Queue

private const val THREE_SECONDS = 3000

class RecentCounter {
    private val requests: Queue<Int> = LinkedList()

    fun ping(t: Int): Int {
        requests.add(t)
        while (t - requests.peek() > 3000) {
            requests.remove()
        }
        return requests.size
    }
}
