package main.binarysearch;

import org.junit.Test;

import java.util.Arrays;

public class SearchInsertPosition_35 {


    public int searchInsert(int[] nums, int target) {

        Arrays.sort(nums);

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high + 1;
    }

    @Test
    public void test() {
        int[] nums = {1, 3, 5, 6};
        System.out.println("Insert position: " + searchInsert(nums, 4));
        System.out.println("Insert position: " + searchInsert(nums, 2));
        System.out.println("Insert position: " + searchInsert(nums, 7));
    }
}
