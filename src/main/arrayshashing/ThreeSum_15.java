package main.arrayshashing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int target = -1 * nums[i];

            int l = i + 1;
            int h = nums.length - 1;

            while (l < h) {

                if (nums[l] + nums[h] == target) {
                    result.add(List.of(nums[i], nums[l], nums[h]));
                    while (l < h && nums[l] == nums[l + 1]) {
                        l++;
                    }

                    while (l < h && nums[h] == nums[h - 1]) {
                        h--;
                    }

                    l++;
                    h--;

                } else if (nums[l] + nums[h] < target) {
                    l++;
                } else {
                    h--;
                }
            }
        }

        return result;
    }

    @Test
    public void test() {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
