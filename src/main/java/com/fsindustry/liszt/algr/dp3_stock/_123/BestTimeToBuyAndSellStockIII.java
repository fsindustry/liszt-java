package com.fsindustry.liszt.algr.dp3_stock._123;

public class BestTimeToBuyAndSellStockIII {
}

class Solution {
    public int maxProfit(int[] prices) {
        if (null == prices || 0 == prices.length) {
            return 0;
        }
        int n = prices.length;
        int K = 2;
        int[][][] cache = new int[n][K + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= K; k++) {
                if (i == 0) {
                    cache[0][k][0] = 0;
                    cache[0][k][1] = -prices[0];
                    continue;
                }

                if (k == 0) {
                    cache[i][0][0] = 0;
                    cache[i][0][1] = -prices[0];
                    continue;
                }

                cache[i][k][0] = Math.max(cache[i - 1][k][0], cache[i - 1][k][1] + prices[i]);
                cache[i][k][1] = Math.max(cache[i - 1][k][1], cache[i - 1][k - 1][0] - prices[i]);
            }
        }

        return cache[n - 1][K][0];
    }
}