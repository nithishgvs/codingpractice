package main.arrayshashing;

import org.junit.Test;

import java.util.*;

public class MinimumDeletionsforAtMostKDistinctCharacters_3545 {

    public int minDeletion(String s, int k) {

        Map<Character, Integer> counter = new HashMap<>();
        int min = 0;

        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.addAll(counter.values());

        int total = minHeap.size();

        while (total > k) {
            min += minHeap.poll();
            total --;
        }
        return min;

    }

    @Test
    public void test() {
        System.out.println(minDeletion("aabb", 2));
    }
}
