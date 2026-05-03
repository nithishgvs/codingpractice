package main.binarysearch;

import org.junit.Test;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray_34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];

        res[0] = binarySearchHelper(nums, target, true);
        res[1] = binarySearchHelper(nums, target, false);


        return res;
    }

    private int binarySearchHelper(int[] nums, int target, boolean findFirst) {

        int l = 0, h = nums.length - 1;
        int res = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                res = mid;
                if (findFirst) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        return res;
    }

    @Test
    public void test() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 6)));

    }
}
