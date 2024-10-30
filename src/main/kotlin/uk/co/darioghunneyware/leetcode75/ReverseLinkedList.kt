package uk.co.darioghunneyware.leetcode75

import uk.co.darioghunneyware.model.ListNode

class ReverseLinkedList {
//    fun reverseList(head: ListNode?): ListNode? {
//        var dummy = ListNode(0)
//        dummy.next = head
//        var previous = ListNode(0)
//
//        while (head != null) {
//            var next = head.next
//            head.next = previous
//            previous = head
//            head = next
//        }
//    }

    /*
     * Time = O(n)
     * Space = O(n)
     * */
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null

        var newHead = head

        if (head.next != null) {
            newHead = reverseList(head.next)
            head.next?.next = head
        }

        head.next = null
        return newHead
    }
}
