package main.heaps;

import org.junit.Test;

import java.util.*;

public class SingleThreadedCPU_1834 {


    public int[] getOrder(int[][] tasks) {

        List<int[]> taskList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            taskList.add(new int[]{i, tasks[i][0], tasks[i][1]});
        }
        Collections.sort(taskList, Comparator.comparingInt(a -> a[1]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2];  // By processing time
            return a[0] - b[0];                     // Then by index
        });

        int time = 1;
        int idx = 0;


        while (!minHeap.isEmpty() || idx < taskList.size()) {

            while (idx < taskList.size() && time >= taskList.get(idx)[1]) {
                minHeap.add(taskList.get(idx));
                idx++;
            }

            if (minHeap.isEmpty())
                time = taskList.get(idx)[1];
            else {
                int[] polled = minHeap.poll();
                result.add(polled[0]);
                time += polled[2];
            }

        }


        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    @Test
    public void test() {
        int[][] array = {
                {1, 2},
                {2, 4},
                {3, 2},
                {4, 1}
        };
        getOrder(array);
    }
}
