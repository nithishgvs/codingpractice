package main.graphs;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges_994 {

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    freshOranges++;
                else if (grid[i][j] == 2)
                    queue.add(new int[]{i, j});
            }
        }

        int steps = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {

            if (freshOranges == 0)
                return steps;

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] popped = queue.poll();

                for (int[] d : dirs) {
                    int x = popped[0] + d[0];
                    int y = popped[1] + d[1];
                    if (x > -1 && x < m && y > -1 && y < n && grid[x][y] == 1) {
                        freshOranges--;
                        queue.add(new int[]{x, y});
                        grid[x][y] = 2;
                    }
                }
            }
            steps++;
        }

        return freshOranges == 0 ? steps : -1;
    }

    @Test
    public void test() {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(grid));
    }

    @Test
    public void test1() {
        int[][] grid = {
                {1,2}
        };
        System.out.println(orangesRotting(grid));
    }
}
