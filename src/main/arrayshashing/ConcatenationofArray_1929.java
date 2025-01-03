package main.arrayshashing;

import org.junit.Test;

public class ConcatenationofArray_1929 {

    public int[] getConcatenation(int[] nums) {

        int[] result = new int[nums.length * 2];

        System.arraycopy(nums, 0, result, 0, nums.length);
        System.arraycopy(nums, 0, result, nums.length, nums.length);
        return result;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 1};
        System.out.println(getConcatenation(nums));
    }
}
