package main.arrayshashing;

public class MinimumSizeSubarraySum_209 {

    public int minSubArrayLen(int target, int[] nums) {

        int min = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        int begin = 0;

        while (begin < nums.length) {
            sum += nums[begin];

            while (sum >= target) {
                min = Math.min(min, begin - start + 1);
                sum -= nums[start];
                start++;
            }
            begin++;
        }


        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum_209 solution = new MinimumSizeSubarraySum_209();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(solution.minSubArrayLen(11, nums));
    }
}
