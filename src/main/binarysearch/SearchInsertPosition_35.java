package main.binarysearch;

import org.junit.Test;

public class SearchInsertPosition_35 {

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return h + 1;
    }

    @Test
    public void test() {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
    }
}
