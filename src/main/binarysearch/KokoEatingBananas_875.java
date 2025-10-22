package main.binarysearch;

import org.junit.Test;

import java.util.Arrays;

public class KokoEatingBananas_875 {

    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);

        int low = 1;
        int high = piles[piles.length - 1];
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canEatBananas(mid, piles, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;

    }

    private boolean canEatBananas(int mid, int[] piles, int h) {
        double total = 0;
        for (int i = 0; i < piles.length; i++) {
            total += Math.ceil(piles[i] * 1.0 / mid);
        }

        return (int) total <= h;
    }

    @Test
    public void test() {
        int[] piles = {30, 11, 23, 4, 20};
        System.out.println(minEatingSpeed(piles, 5));
    }
}
