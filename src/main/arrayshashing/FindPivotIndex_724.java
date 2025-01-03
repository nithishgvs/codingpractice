package main.arrayshashing;

import org.junit.Test;

import java.util.Arrays;

public class FindPivotIndex_724 {

    public int pivotIndex(int[] nums) {

        int sum = Arrays.stream(nums).sum();

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum - (prefixSum + nums[i]) == prefixSum) {
                return i;
            }
            prefixSum += nums[i];
        }


        return -1;

    }

    @Test
    public void test() {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums2 = {2, -1, 1};
        System.out.println(pivotIndex(nums2));
    }
}
