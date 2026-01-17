package main.arrayshashing;

import org.junit.Test;


public class ValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {

        // rows[r][d] == true means digit d+1 has already appeared in row r.
        boolean[][] rows = new boolean[9][9];
        // cols[c][d] == true means digit d+1 has already appeared in column c.
        boolean[][] cols = new boolean[9][9];
        // boxes[b][d] == true means digit d+1 has already appeared in 3x3 box b.
        boolean[][] boxes = new boolean[9][9];

        // Iterate every cell in the 9x9 board.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                // Empty cells are ignored.
                if (board[i][j] == '.')
                    continue;

                // Convert character '1'..'9' to a zero-based index 0..8.
                int digit = board[i][j] - '1';
                // Map (row, col) to one of the 9 boxes numbered 0..8.
                int boxIndex = (i / 3) * 3 + (j / 3);

                // If the digit was already seen in this row, column, or box, it's invalid.
                if (rows[i][digit] || cols[j][digit] || boxes[boxIndex][digit])
                    return false;

                // Mark the digit as seen in the current row, column, and box.
                rows[i][digit] = true;
                cols[j][digit] = true;
                boxes[boxIndex][digit] = true;
            }
        }

        // No conflicts found.
        return true;
    }

    @Test
    public void test() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));
    }
}
