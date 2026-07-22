package uk.co.darioghunneyware.leetcode75;

import uk.co.darioghunneyware.leetcode75.model.ListNode;

public class DeleteMiddleNode {

//    public ListNode deleteMiddle(ListNode head) {
//        if (head.next == null) {
//            return null;
//        }
//
//        int size = 1;
//        ListNode copy =  head;
//        while (copy.next != null) {
//            size++;
//            copy = copy.next;
//        }
//
//        int mid = size / 2;
//
//        return findMiddleNode(head, mid);
//    }
//
//    private ListNode findMiddleNode(ListNode node, int mid) {
//        if (node.next == null) {
//            return null;
//        }
//
//        if (mid == 1) {
//            node.next = node.next.next;
//            return node;
//        }
//
//        node.next = findMiddleNode(node.next, --mid);
//        return node;
//    }

    /*
    * O(n) time, O(1) space:
    *
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        int size = 1;
        ListNode copy = head;

        while (copy.next != null) {
            size++;
            copy = copy.next;
        }

        findMiddleNode(head, size / 2);
        return head;
    }

    private void findMiddleNode(ListNode node, int mid) {
        if (mid == 1) {
            node.next = node.next.next;
            return;
        }

        findMiddleNode(node.next, mid - 1);
    }
    * */
}
