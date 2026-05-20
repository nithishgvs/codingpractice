package main.heaps;

import java.util.PriorityQueue;

public class KthLargestElementinanArray_215 {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.peek();

    }

    public static void main(String[] args) {
        KthLargestElementinanArray_215 obj = new KthLargestElementinanArray_215();
        System.out.println(obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }
}
