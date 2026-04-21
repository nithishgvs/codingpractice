package main.arrayshashing;

import java.util.Arrays;

public class FindPivotIndex_724 {

    public int pivotIndex(int[] nums) {

        int sum = Arrays.stream(nums).sum();

        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {

            int rightSum = sum - leftSum - nums[i];

            if (leftSum == rightSum)
                return i;

            leftSum += nums[i];

        }

        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex_724 obj = new FindPivotIndex_724();
        System.out.println(obj.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
