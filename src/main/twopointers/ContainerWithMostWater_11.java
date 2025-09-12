package main.twopointers;

import org.junit.Test;

public class ContainerWithMostWater_11 {

    public int maxArea(int[] height) {

        int maxArea = Integer.MIN_VALUE;

        int left = 0, right = height.length - 1;

        while (left < right) {

            maxArea = Math.max(maxArea, Math.max(0, Math.min(height[left], height[right]) * (right - left)));

            if (height[left] < height[right])
                left++;
            else
                right--;

        }


        return maxArea;

    }

    @Test
    public void test() {
        int[] heights = {1,1};
        System.out.println(maxArea(heights));
    }
}
