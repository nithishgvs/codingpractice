package main.arrayshashing;

import org.junit.Test;

public class FurthestPointFromOrigin_2833 {

    public int furthestDistanceFromOrigin(String moves) {

        int balance = 0;
        int blanks = 0;

        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') {
                balance -= 1;
            } else if (moves.charAt(i) == 'R') {
                balance += 1;
            } else {
                blanks++;
            }
        }

        return Math.abs(balance) + blanks;
    }

    @Test
    public void test() {
        System.out.println(furthestDistanceFromOrigin("_R__LL_"));
    }
}
