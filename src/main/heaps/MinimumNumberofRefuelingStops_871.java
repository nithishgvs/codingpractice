package main.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops_871 {


    public int minRefuelStops(int target, int startFuel, int[][] stations) {

        int totalStops = 0;

        int maxYouCanReach = startFuel;

        int index = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


        while (maxYouCanReach < target) {

            // Add every station we can reach with the current fuel.
            // When we need to refuel, always pick the largest fuel amount seen so far.
            while (index < stations.length && stations[index][0] <= maxYouCanReach) {
                maxHeap.add(stations[index][1]);
                index++;
            }

            if (maxHeap.isEmpty()) {
                return -1;
            }


            maxYouCanReach += maxHeap.poll();
            totalStops++;
        }

        return totalStops;

    }
}
