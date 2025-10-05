package main.arrayshashing;

import java.util.Arrays;

public class GasStation_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalSum = 0, currTank = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalSum += diff;
            currTank += diff;

            if (currTank < 0) {
                start = i + 1;
                currTank = 0;
            }
        }

        return totalSum < 0 ? -1 : start;
    }
}
