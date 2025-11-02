package main.graphs;

import org.junit.Test;

import java.util.*;

public class NetworkDelayTime_743 {

    public int networkDelayTime(int[][] times, int n, int k) {

        Set<Integer> receivedSignal = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            receivedSignal.add(i);
        }

        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();

        for (int[] time : times) {
            adjacencyList.computeIfAbsent(time[0], _ -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(v -> v[1]));

        minHeap.addAll(adjacencyList.getOrDefault(k, new ArrayList<>()));
        receivedSignal.remove(k);

        while (!minHeap.isEmpty()) {

            int[] polled = minHeap.poll();
            int src = polled[0], cost = polled[1];

            if (!receivedSignal.contains(src))
                continue;
            receivedSignal.remove(src);

            if (receivedSignal.isEmpty())
                return cost;
            for (int[] adj : adjacencyList.getOrDefault(src, new ArrayList<>())) {
                minHeap.add(new int[]{adj[0], cost + adj[1]});
            }

        }

        return receivedSignal.isEmpty() ? Integer.MAX_VALUE : -1;

    }

    @Test
    public void test() {
        int[][] times = {
                {1, 2, 1}
        };
        networkDelayTime(times, 2, 2);
    }
}
