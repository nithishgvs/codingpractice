package main.arrayshashing;

import org.junit.Test;

public class BestTimetoBuyandSellStock_121 {


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int minBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }
        return maxProfit;
    }


    @Test

    public void test() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
