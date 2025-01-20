package main.binarysearch;

import org.junit.Test;

public class FindMinimuminRotatedSortedArray_153 {

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
        int[] nums = {3, 4, 5, 1, 2};
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {11, 13, 15, 17};
        int[] nums3 = {3,1,2};

        System.out.println(findMin(nums));
        System.out.println(findMin(nums1));
        System.out.println(findMin(nums2));
        System.out.println(findMin(nums3));
    }
}
