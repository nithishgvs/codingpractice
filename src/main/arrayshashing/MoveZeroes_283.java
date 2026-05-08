package main.arrayshashing;

import org.junit.Test;

public class MoveZeroes_283 {

    public void moveZeroes(int[] nums) {

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    @Test
    public void test1() {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

}
