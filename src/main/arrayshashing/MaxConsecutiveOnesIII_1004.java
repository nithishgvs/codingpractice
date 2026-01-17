package main.arrayshashing;

import org.junit.Test;

public class MaxConsecutiveOnesIII_1004 {

    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeros = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;

            while (zeros > k) {
                if (nums[left] == 0) zeros--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    @Test
    public void test() {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(longestOnes(nums, 3));
    }

    @Test
    public void test1() {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnes(nums, 2));
    }
}
