package main.arrayshashing;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ProductofArrayExceptSelf_238 {


    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int zeroCount = 0;

        int product = 1;

        for (int num : nums) {
            if (num != 0) {
                product *= num;
            } else {
                zeroCount++;
            }
        }

        if (zeroCount > 1)
            return result;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (zeroCount == 0)
                    result[i] = product / nums[i];
            } else {
                result[i] = product;
            }
        }

        return result;

    }


    @Test
    public void test() {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] nums2 = {0, 0, 0, 0};
        int[] nums3 = {1, 2, 3, 4};
        productExceptSelf(nums);
        productExceptSelf(nums2);
        productExceptSelf(nums3);
    }

}

