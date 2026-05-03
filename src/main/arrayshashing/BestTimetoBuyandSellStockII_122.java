package main.arrayshashing;

import org.junit.Test;

import java.util.Arrays;

public class BestTimetoBuyandSellStockII_122 {

    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }

        }
        return max;
    }

    @Test
    public void test() {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }
}
