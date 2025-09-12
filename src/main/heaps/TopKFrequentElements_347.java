package main.heaps;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements_347 {

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.computeIfAbsent(num, key -> 0);
            countMap.put(num, countMap.get(num) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        maxHeap.addAll(countMap.entrySet());

        for (int i = 0; i < k; i++) {
            if (!maxHeap.isEmpty()) {
                result[i] = maxHeap.poll().getKey();
            }
        }

        return result;
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        topKFrequent(nums, 2);
    }
}
