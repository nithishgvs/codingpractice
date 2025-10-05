package main.linkedlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists_23 {

    public ListNode mergeKLists(ListNode[] lists) {

        //Edge case
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a.val));

        for (ListNode listNode : lists) {
            if (listNode != null)
                minHeap.add(listNode);
        }

        ListNode dummy = new ListNode(-1);

        ListNode nextNode = dummy;

        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            nextNode.next = smallest;
            nextNode = nextNode.next;

            if (smallest.next != null)
                minHeap.add(smallest.next);
        }

        return dummy.next;
    }
}
