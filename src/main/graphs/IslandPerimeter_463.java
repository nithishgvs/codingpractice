package main.graphs;

import org.junit.Test;

import java.util.Arrays;

public class IslandPerimeter_463 {

    int total = 0;

    public int islandPerimeter(int[][] grid) {


        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j])
                    dfs(i, j, grid, visited);
            }
        }
        return total;

    }

    private void dfs(int row, int col, int[][] grid, boolean[][] visited) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || visited[row][col])
            return;

        visited[row][col] = true;
        total += 4;
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        for (int[] d : dirs) {

            int nr = row + d[0];
            int nc = col + d[1];

            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1)
                total -= 1;
        }

        for (int[] d : dirs) {
            dfs(row + d[0], col + d[1], grid, visited);
        }
    }


    @Test
    public void test() {
        int[][] matrix = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };
        System.out.println(islandPerimeter(matrix));
    }
}

