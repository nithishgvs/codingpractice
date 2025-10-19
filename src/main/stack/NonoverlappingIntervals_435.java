package main.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class NonoverlappingIntervals_435 {

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator
                .comparingInt((int[] value) -> value[0])
                .thenComparingInt(value -> value[1]));

        Stack<int[]> stack = new Stack<>();
        stack.add(intervals[0]);
        int min = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (!stack.isEmpty() && stack.peek()[1] > intervals[i][0]) {
                min++;
                //Decide whom to keep
                //Keep the interval with smaller end time
                if (stack.peek()[1] > intervals[i][1]) {
                    stack.pop();
                    stack.add(intervals[i]);
                }

            } else {
                stack.add(intervals[i]);
            }

        }
        return min;
    }


    @Test
    public void test() {
        int[][] arr = {
                {-52, 31},
                {-73, -26},
                {82, 97},
                {-65, -11},
                {-62, -49},
                {95, 99},
                {58, 95},
                {-31, 49},
                {66, 98},
                {-63, 2},
                {30, 47},
                {-40, -26}
        };
        eraseOverlapIntervals(arr);
    }
}
