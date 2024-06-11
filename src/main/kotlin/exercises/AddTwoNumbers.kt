package exercises

import model.ListNode

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val l1Str = getNumber(l1)
        val l2Str = getNumber(l2)
        val sumNum: String
        val l1Num = l1Str.toBigInteger()
        val l2Num = l2Str.toBigInteger()

        sumNum = l1Num.add(l2Num).toString()

        return numberToNode(sumNum)
    }

    private fun numberToNode(number: String): ListNode? {
        val dummyHead = ListNode(0)
        var current = dummyHead

        for (char in number.reversed()) {
            val digit = char.toString().toInt()
            val newNode = ListNode(digit)
            current.next = newNode
            current = newNode
        }

        // Return the next of dummyHead as the head of the resulting list
        return dummyHead.next
    }

    private fun getNumber(node: ListNode?): String {
        if (node == null) return ""

        var str = getNumber(node.next)
        str += node.`val`.toString()
        return str
    }

//    Other solution
    fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
        var dummy = ListNode(0)
        var l1Copy = l1
        var l2Copy = l2
        var l3 = dummy
        var carry = 0

        while (l1Copy != null || l2Copy != null) {
            var l1Val = l1Copy?.`val` ?: 0
            var l2Val = l2Copy?.`val` ?: 0

            var currentSum = l1Val + l2Val + carry
            carry = currentSum / 10
            var lastDigit = currentSum % 10

            var newNode = ListNode(lastDigit)
            l3.next = newNode

            l1Copy = l1Copy?.next
            l2Copy = l2Copy?.next
            l3 = l3.next!!
        }

        if (carry > 0) {
            val newNode = ListNode(carry)
            l3.next = newNode
            l3 = l3.next!!
        }

        return dummy.next
    }
}