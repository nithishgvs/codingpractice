package main.heaps;

import org.junit.Test;

import java.util.*;

public class ReorganizeString_767 {

    public String reorganizeString(String s) {

        Map<Character, Integer> counter = new HashMap<>();

        for (char ch : s.toCharArray()) {
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>(
                        Comparator.comparingInt((Map.Entry<Character, Integer> e) -> e.getValue()).reversed());

        maxHeap.addAll(counter.entrySet());

        StringBuilder sb = new StringBuilder();

        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            sb.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            queue.add(entry);
            if (queue.size() > 1) {
                Map.Entry<Character, Integer> polled = queue.poll();
                if (polled.getValue() > 0)
                    maxHeap.add(polled);
            }
        }


        return sb.length() == s.length() ? sb.toString() : "";
    }

    @Test
    public void test() {
        reorganizeString("aaab");
    }
}
