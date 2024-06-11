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

        var slow = head
        var fast = head.next

        while (slow != fast) {
            if (fast?.next == null || fast.next?.next == null) {
                return null
            } else {
                slow = slow?.next
                fast = fast.next?.next
            }
        }
        return slow
    }
}