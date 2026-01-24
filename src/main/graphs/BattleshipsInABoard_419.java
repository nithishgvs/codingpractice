package main.graphs;

import org.junit.Test;

public class BattleshipsInABoard_419 {

    //If we start from a cell which has value X we check above cell or one below, if it has valid value above or left it means it belongs to same battleship
    //Question says horizontally/vertically so we only check these two conditions
    public int countBattleships(char[][] board) {

        int count = 0;
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'X') {
                    //Check two conditions now one above one left so this helps to make sure it belongs to same battle ship
                    boolean noXAbove = (i == 0) || (board[i - 1][j] == '.');
                    boolean noXLeft = (j == 0) || (board[i][j - 1] == '.');
                    if (noXAbove && noXLeft)
                        count++;
                }
            }
        }


        return count;

    }

    @Test
    public void test() {

        char[][] grid = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };
        System.out.println(countBattleships(grid));
    }
}
