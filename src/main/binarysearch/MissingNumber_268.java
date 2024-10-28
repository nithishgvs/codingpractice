package main.binarysearch;

import org.junit.Test;

import java.util.Arrays;

public class MissingNumber_268 {

    public int missingNumber(int[] nums) {

        int l = 0;
        int h = nums.length - 1;

        Arrays.sort(nums);

        while (l <= h) {

            int mid = l + (h - l) / 2;

            if (nums[mid] == mid) {
                //element at index is equal to element which means array is sorted until here and no element is missing
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return l;
    }

    @Test
    public void test() {
        int[] nums = {0, 1, 2};
        System.out.println(missingNumber(nums));
    }
}
