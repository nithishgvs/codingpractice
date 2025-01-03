package main.arrayshashing;

import org.junit.Test;

import java.util.Arrays;

public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {

        Arrays.sort(nums);

        int[] res = new int[2];

        int l = 0, h = nums.length - 1;

        while (l < h) {
            int sum = nums[l] + nums[h];
            if (sum == target) {
                res[0] = l;
                res[1] = h;
                break;
            } else if (sum > target) {
                h--;
            } else {
                l++;
            }
        }

        return res;
    }

    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
        System.out.println(twoSum(nums, 9));
    }
}
