package uk.co.darioghunneyware.leetcode75;

import uk.co.darioghunneyware.leetcode75.model.ListNode;

public class LeetCode75 {

    public static void main(String[] args) {
//        ListNode node = new ListNode(1);
//        node.next = new ListNode(3);
//        node.next.next = new ListNode(4);
//        node.next.next.next = new ListNode(7);
//        node.next.next.next.next = new ListNode(1);
//        node.next.next.next.next.next = new ListNode(2);
//        node.next.next.next.next.next.next = new ListNode(6);
//        DeleteMiddleNode deleteMiddleNode = new DeleteMiddleNode();
        MaxVowelsGivenLength maxVowelsGivenLength = new MaxVowelsGivenLength();

        System.out.println(maxVowelsGivenLength.maxVowels("leetcode", 3));
    }
}
