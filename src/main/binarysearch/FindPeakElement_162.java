package main.binarysearch;

import org.junit.Test;

public class FindPeakElement_162 {

    public int findPeakElement(int[] nums) {

        if (nums.length == 1)
            return 0;

        if (nums[0] > nums[1])
            return 0;

        if (nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;

        int l = 1, h = nums.length - 2;

        int ans = -1;

        while (l <= h) {

            int mid = l + (h - l) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                ans = mid;
                break;
            } else if (nums[mid] > nums[mid - 1]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }

        }

        return ans;
    }


    @Test
    public void test() {
        int[] nums = {1, 2, 3, 1};
        System.out.println("Peak Element: " + findPeakElement(nums));
    }
}
