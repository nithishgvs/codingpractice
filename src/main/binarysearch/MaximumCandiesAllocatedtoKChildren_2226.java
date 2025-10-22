package main.binarysearch;

import org.junit.Test;

import java.util.Arrays;

public class MaximumCandiesAllocatedtoKChildren_2226 {

    public int maximumCandies(int[] candies, long k) {
        int max = 0;

        int l = 1;
        int h = 0;
        for (int i : candies) {
            h = Math.max(h, i);
        }
        //You are binary-searching on the answer space (pile size), which is naturally sorted so the candies can be in any order
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (canDistributeCandies(candies, mid, k)) {
                max = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return max;

    }

    private boolean canDistributeCandies(int[] candies, int mid, long k) {
        long current = 0;
        for (int i = 0; i < candies.length; i++) {
            current += candies[i] / mid;
            if (current >= k) {
                return true;
            }
        }
        return false;
    }


    @Test
    public void test() {
        System.out.println(maximumCandies(new int[]{5, 8, 6}, 3));
        System.out.println(maximumCandies(new int[]{4, 7, 5}, 4));
    }
}
