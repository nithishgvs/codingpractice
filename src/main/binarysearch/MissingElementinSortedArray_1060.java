package main.binarysearch;

import org.junit.Test;

public class MissingElementinSortedArray_1060 {


    public int missingElement(int[] nums, int k) {


        int l = 0, h = nums.length - 1;


        int missingElements = 0;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            missingElements = nums[mid] - (nums[0] + mid);
            if (missingElements < k) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }


        return nums[h] + k - (nums[h] - (nums[0] + h));

    }

    @Test
    public void test() {
        int[] nums = {1, 2, 4};
        System.out.println("Missing element: " + missingElement(nums, 3));
    }

    @Test
    public void test1() {
        int[] nums = {746421, 1033196, 1647541, 4775111, 7769817, 8030384};
        System.out.println("Missing element: " + missingElement(nums, 10));
    }
}
