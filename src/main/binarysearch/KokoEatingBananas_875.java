package main.binarysearch;

import org.junit.Test;

import java.util.Arrays;

public class KokoEatingBananas_875 {

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int res = -1;
        int low = 1;
        int high = piles[piles.length - 1];

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canFinish(piles, h, mid)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    private boolean canFinish(int[] piles, int h, int mid) {

        Double total = Double.valueOf(0);
        for (int i = 0; i < piles.length; i++) {
            total += Math.ceil((double) piles[i] / mid);
        }
        return total.intValue() <= h;
    }

    @Test
    public void test1() {
        int[] piles = {30, 11, 23, 4, 20};
        System.out.println(minEatingSpeed(piles, 5));
    }
}
