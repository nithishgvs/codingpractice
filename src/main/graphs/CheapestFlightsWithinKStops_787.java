package main.graphs;

import org.junit.Test;

import java.util.*;

public class CheapestFlightsWithinKStops_787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        //This map holds the adjacent destination and their price
        Map<Integer, List<int[]>> adjacencyMap = new HashMap<>();

        for (int[] flight : flights) {
            //Source vs Dest+price in a list
            adjacencyMap.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);

        //MinHeap declaration
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
        //Source,steps,cost
        minHeap.add(new int[]{src, 0, 0});

        while (!minHeap.isEmpty()) {

            int[] polled = minHeap.poll();
            int city = polled[0], stops = polled[1], cost = polled[2];

            if (city == dst)
                return cost;

            if (stops > k || stops > minStops[city])
                continue;

            minStops[city] = stops;

            for (int[] adj : adjacencyMap.getOrDefault(city, new ArrayList<>())) {
                minHeap.add(new int[]{adj[0], stops + 1, cost + adj[1]});
            }
        }


        return -1;
    }

    @Test
    public void test() {
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        System.out.println(findCheapestPrice(3, flights, 0, 2, 1));
    }
}
