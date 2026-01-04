package main.graphs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow_417 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(i, cols - 1, heights, atlantic);
            dfs(i, 0, heights, pacific);
        }

        for (int j = 0; j < cols; j++) {
            dfs(0, j, heights, pacific);
            dfs(rows-1, j, heights, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col, int[][] heights, boolean[][] ocean) {
        ocean[row][col] = true;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        //This is called reverse DFS.
        for (int[] d : dirs) {
            int nr = row + d[0];
            int nc = col + d[1];
            if (nc > -1 && nr > -1 && nr < heights.length && nc < heights[0].length && heights[nr][nc] >= heights[row][col] && !ocean[nr][nc]) {
                dfs(nr, nc, heights, ocean);
            }
        }
    }

    @Test
    public void test() {
        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        pacificAtlantic(matrix);
    }


    @Test
    public void test1() {
        int[][] matrix = {
                {1}
        };

        pacificAtlantic(matrix);
    }
}
