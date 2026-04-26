package main.arrayshashing;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray_448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> outputList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (nums[index] > 0) {
                nums[index] = -1 * nums[index];
            }
        }


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                outputList.add(i + 1);
        }

        return outputList;
    }

    @Test
    public void test() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
