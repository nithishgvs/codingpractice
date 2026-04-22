package main.linkedlist;

import org.junit.Test;

public class DeleteNodesFromLinkedListPresentinArray_3217 {

    public ListNode modifiedList(int[] nums, ListNode head) {

        boolean[] shouldDelete = new boolean[100001];

        for (int num : nums) {
            shouldDelete[num] = true;
        }

        ListNode tempHead = new ListNode(-1, head);
        ListNode current = head;
        ListNode previous = tempHead;

        while (current != null) {
            if (shouldDelete[current.val]) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
        return tempHead.next;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(2);
        head.next = new ListNode(10);
        head.next.next = new ListNode(9);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);

        modifiedList(new int[]{9, 2, 5}, head);
    }
}
