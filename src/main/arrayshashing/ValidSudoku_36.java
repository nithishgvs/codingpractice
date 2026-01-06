package main.arrayshashing;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku_36 {

    public boolean isValidSudoku(char[][] board) {

        Set<String> rows = new HashSet<>();
        Set<String> cols = new HashSet<>();
        Set<String> boxes = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.')
                    continue;

                String rowData = board[i][j] + " is seen in row: " + i;
                String colData = board[i][j] + " is seen in col: " + j;
                int boxLocation = (i / 3) * 3 + (j / 3);
                String boxData = board[i][j] + " is seen in box: " + boxLocation;

                if (rows.contains(rowData) || cols.contains(colData) || boxes.contains(boxData))
                    return false;

                rows.add(rowData);
                cols.add(colData);
                boxes.add(boxData);


            }
        }

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
