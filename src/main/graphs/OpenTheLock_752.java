package main.graphs;

import org.junit.Test;

import java.util.*;

public class OpenTheLock_752 {

    /**
     * Problem Summary
     * Start: "0000"
     * Goal: Reach target in minimum moves
     * Constraint: Avoid deadends
     * One move: Turn ONE wheel by ONE slot
     * <p>
     * Key Insight: BFS for Shortest Path
     * Level 0:  "0000"  (start)
     * Level 1:  8 neighbors  (1 move away)
     * Level 2:  8 neighbors each  (2 moves away)
     * ...
     * Level N:  target found → return N
     *
     * @param deadends
     * @param target
     * @return
     */

    public int openLock(String[] deadends, String target) {
        int moves = 0;

        Set<String> visited = new HashSet<>();
        visited.addAll(Arrays.asList(deadends));
        if (visited.contains("0000"))
            return -1;
        Queue<String> queue = new ArrayDeque<>();
        queue.add("0000");
        visited.add("0000");


        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target))
                    return moves;
                visited.add(current);
                for (String neighbour : getNeighBours(current)) {
                    if (!visited.contains(neighbour)) {
                        queue.add(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private List<String> getNeighBours(String current) {

        List<String> neighbours = new ArrayList<>();

        char[] chars = current.toCharArray();

        for (int i = 0; i < 4; i++) {

            int digit = (chars[i] - '0') % 10;

            //Up increment
            chars[i] = (char) ('0' + (digit + 1) % 10);
            neighbours.add(new String(chars));
            //
            chars[i] = (char) ('0' + (digit - 1 + 10) % 10);
            neighbours.add(new String(chars));

            //By now number is changed in the char array so as we have the digit we revert back to the current number and move on to the next character
            chars[i] = (char) ('0' + digit);
        }

        return neighbours;

    }

    @Test
    public void test() {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(openLock(deadends, "0202"));
    }
}
