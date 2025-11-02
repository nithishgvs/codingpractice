package main.binarysearch;

import org.junit.Test;

import java.util.Arrays;

public class CounttheNumberofFairPairs_2563 {

    public long countFairPairs(int[] nums, int lower, int upper) {
        //Used chatgpt to understand the solution as my 2 ptr solution failed
        Arrays.sort(nums);
        //This is a Binary search problwm where we do 2 counts
        //Pairs whose sum is <=upper ( this has the ones in range of lower to upper and sums less than lower also)
        //Pairs whose sum is < upper this has only sums less than lower only
        //Minus first with second will give sums in the range of lower and upper
        return countLessEqual(nums, upper) - countLessEqual(nums, lower - 1);
    }

    private long countLessEqual(int[] nums, int bound) {
        long count = 0;

        int l = 0, h = nums.length - 1;

        while (l < h) {
            if (nums[l] + nums[h] <= bound) {
                count += h - l;
                l++;
            } else {
                h--;
            }
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(countFairPairs(new int[]{1, 7, 9, 2, 5}, 11, 11));
    }


}
