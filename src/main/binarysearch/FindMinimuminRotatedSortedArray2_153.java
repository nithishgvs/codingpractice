package main.binarysearch;

import org.junit.Test;

public class FindMinimuminRotatedSortedArray2_153 {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;

        while (l < h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] < nums[h]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }


        return nums[l];
    }

    @Test
    public void test() {
        int[] nums = {2, 3, 4, 5, 1};
        System.out.println(findMin(nums));
    }


}
