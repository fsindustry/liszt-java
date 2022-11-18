package com.fsindustry.liszt.dp3_stock._714;

public class BestTimeToBuyAndSellStockWithTransactionFee {
}

class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (null == prices || 0 == prices.length) {
            return 0;
        }

        int n = prices.length;
        int i0 = 0, i1 = -fee - prices[0];
        for (int i = 0; i < n; i++) {
            int tmp = i0;
            i0 = Math.max(i0, i1 + prices[i]);
            i1 = Math.max(i1, tmp - fee - prices[i]);
        }
        return i0;
    }
}

class Solution1 {
    public int maxProfit(int[] prices, int fee) {
        if (null == prices || 0 == prices.length) {
            return 0;
        }

        int n = prices.length;
        int[][] cache = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                cache[0][0] = 0;
                cache[0][1] = -fee - prices[0];
                continue;
            }

            cache[i][0] = Math.max(cache[i - 1][0], cache[i - 1][1] + prices[i]);
            cache[i][1] = Math.max(cache[i - 1][1], cache[i - 1][0] - fee - prices[i]);
        }
        return cache[n - 1][0];
    }
}