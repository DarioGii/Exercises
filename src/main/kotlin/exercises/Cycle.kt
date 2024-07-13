package exercises

import model.ListNode

class Cycle {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false

        var slow = head
        var fast = head.next

        while (slow != fast) {
            if (fast?.next == null || fast.next?.next == null) {
                return false
            } else {
                slow = slow?.next
                fast = fast.next?.next
            }
        }
        return true
    }

    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) return null

        var intersect: ListNode? = findIntersection(head) ?: return null

        var start = head.next

        while (start != intersect) {
            start = start?.next
            intersect = intersect?.next?.next
        }

        return start?.next
    }

    private fun findIntersection(node: ListNode?): ListNode? {
        var slow = node
        var fast = node?.next

        while (fast?.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) return slow
        }

        return null
    }
}
