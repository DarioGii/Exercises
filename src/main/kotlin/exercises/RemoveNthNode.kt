package exercises

import model.ListNode

// fixMe
class RemoveNthNode {
    fun removeNthFromEnd(
        head: ListNode?,
        n: Int,
    ): ListNode? {
        val dummyHead = ListNode(0).apply { next = head }
        var slow = dummyHead
        var fast = head.getOrNull(n)

        while (fast != null) {
            fast = fast.next
            slow = checkNotNull(slow.next)
        }
        val nodeToRemove = slow.next
        slow.next = nodeToRemove?.next
        nodeToRemove?.next = null
        return dummyHead.next
    }

    private fun ListNode?.getOrNull(index: Int): ListNode? {
        var result = this
        var i = 0

        while (i < index && result != null) {
            result = result.next
            i++
        }
        return result
    }
}
