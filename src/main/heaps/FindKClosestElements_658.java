package main.heaps;

import org.junit.Test;

import java.util.*;

public class FindKClosestElements_658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (int i : arr) {
            minHeap.add(new int[]{i, Math.abs(i - x)});
        }
        int i = 0;
        List<Integer> result = new ArrayList<>();
        while (i < k) {
            result.add(minHeap.poll()[0]);
            i++;
        }
        Collections.sort(result);
        return result;

    }

    @Test
    public void test() {
        int[] nums = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};

        System.out.println(findClosestElements(nums, 3, 5));
    }
}
