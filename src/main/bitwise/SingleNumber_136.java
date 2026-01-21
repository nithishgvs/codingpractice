package main.bitwise;

import org.junit.Test;

public class SingleNumber_136 {

    public int singleNumber(int[] nums) {

        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;

    }

    @Test
    public void test() {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }
}
