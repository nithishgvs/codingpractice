package main.bitwise;

import org.junit.Test;

public class NumberOf1Bits_191 {


    //4 100 and 3 011 returns 0
    //5 101 and 4 100 clears lowest set bit ( becomes 100 last 1 is gone)
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);  // Clears lowest set bit
            count++;
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(hammingWeight(128));
    }
}
