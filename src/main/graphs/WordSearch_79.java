package main.graphs;

import org.junit.Test;

public class WordSearch_79 {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && helper(visited, 0, word, board, i, j)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean helper(boolean[][] visited, int currentIndex, String word, char[][] board, int row, int column) {

        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length || visited[row][column] || currentIndex >= word.length() || word.charAt(currentIndex) != board[row][column])
            return false;

        if (currentIndex == word.length() - 1)
            return true;


        visited[row][column] = true;

        currentIndex += 1;

        boolean found = helper(visited, currentIndex, word, board, row + 1, column) ||
                helper(visited, currentIndex, word, board, row - 1, column) ||
                helper(visited, currentIndex, word, board, row, column + 1) ||
                helper(visited, currentIndex, word, board, row, column - 1);

        visited[row][column] = false;

        return found;

    }

    @Test
    public void test() {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(board, "ABCB"));
    }
}
