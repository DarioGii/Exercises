package uk.co.darioghunneyware.exercises

import uk.co.darioghunneyware.model.ListNode

class RemoveDuplicates {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size == 1) return 1

        val occurrenceMap: MutableMap<Int, Int> = mutableMapOf()

        for (num in nums) {
            var currentNum = num

            for (index in 1..<nums.size) {
                if (nums[index - 1] == currentNum) {
                    if (occurrenceMap.containsKey(currentNum)) {
                        if (occurrenceMap[currentNum]!! >= 1) {
                            nums[index - 1] = 101
                        }
                    } else {
                        occurrenceMap[currentNum] = 1
                    }
                }
            }
        }

        nums.sort()
        return nums.count { it != 101 }
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return head

        var first = head
        var pos = 0
        val duplicatePos = mutableListOf<Int>()

        while (first != null) {
            if (first.`val` == first.next?.`val`) {
                if (!duplicatePos.contains(pos)) {
                    duplicatePos.add(pos)
                    duplicatePos.add(pos.inc())
                } else {
                    duplicatePos.add(pos.inc())
                }
            }

            first = first.next
            pos++
        }

        pos = 0
        var temp = head

        while (temp != null) {
            if (duplicatePos.contains(pos)) {
                temp?.next = temp?.next?.next
            } else {
                temp = temp.next
            }

            pos++
        }

        return head
    }
}
