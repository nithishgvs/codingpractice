package main.greedy;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CinemaSeatAllocation_1386 {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Set<Integer>> rowsToSeats = new HashMap<>();

        for (int[] reserved : reservedSeats) {
            int row = reserved[0];
            int seat = reserved[1];
            rowsToSeats.computeIfAbsent(row, missingRow -> new HashSet<>()).add(seat);
        }

        //For empty rows we can add 2 sets each this is important to avoid TLE
        int max = (n - rowsToSeats.size()) * 2;

        //Now only check the reserved rows logic
        for (Set<Integer> seats : rowsToSeats.values()) {

            boolean left = !seats.contains(2) && !seats.contains(3) && !seats.contains(4) && !seats.contains(5);
            boolean middle = !seats.contains(4) && !seats.contains(5) && !seats.contains(6) && !seats.contains(7);
            boolean right = !seats.contains(6) && !seats.contains(7) && !seats.contains(8) && !seats.contains(9);

            if (left && right) {
                max += 2;
            } else if (left || middle || right) {
                max += 1;
            }
        }

        return max;
    }

    @Test
    public void test() {
        int[][] reservedSeats = {
                {1, 2},
                {1, 3},
                {1, 8},
                {2, 6},
                {3, 1},
                {3, 10}
        };
        System.out.println(maxNumberOfFamilies(3, reservedSeats));
    }
}
