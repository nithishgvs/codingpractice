package main.slidingwindow;

import org.junit.Test;

import java.util.Arrays;

public class FrequencyoftheMostFrequentElement_1838 {

    public int maxFrequency(int[] nums, int k) {
        int maxFrequency = 1;
        Arrays.sort(nums);
        long sum = 0;
        int left = 0;


        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (((long) nums[right] * (right - left + 1) - sum) > k) {
                sum -= nums[left];
                left++;
            }

        maxFrequency = Math.max(maxFrequency, right - left + 1);
    }
        return maxFrequency;

}

@Test
public void test() {
    int[] nums = {1, 2, 4};
    System.out.println(maxFrequency(nums, 5));
}
}
