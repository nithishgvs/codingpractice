package main.twopointers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int currentIndex = 0; currentIndex < nums.length - 2; currentIndex++) {
            int currentNumber = nums[currentIndex];


            int low = currentIndex + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sumNeeded = 0 - currentNumber;
                if (nums[low] + nums[high] == sumNeeded) {
                    result.add(Arrays.asList(currentNumber, nums[low], nums[high]));
                    while (low + 1 < nums.length && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    low++;
                    while (high - 1 > -1 && nums[high - 1] == nums[high]) {
                        high--;
                    }
                    high--;
                } else if (nums[low] + nums[high] > sumNeeded) {
                    high--;
                } else {
                    low++;
                }
            }


            while (currentIndex + 1 < nums.length && nums[currentIndex] == nums[currentIndex + 1]) {
                currentIndex++;
            }

        }

        return result;
    }

    @Test
    public void test() {
        //threeSum(new int[]{-2, 0, 0, 2, 2});
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
