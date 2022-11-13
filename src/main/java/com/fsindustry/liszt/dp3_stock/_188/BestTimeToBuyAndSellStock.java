package com.fsindustry.liszt.dp3_stock._188;

public class BestTimeToBuyAndSellStock {
}


class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (0 == n) {
            return 0;
        }

        int[][][] cache = new int[n][k + 1][2];
        // curK == 0
        for (int i = 0; i < n; i++) {
            cache[i][0][0] = 0;
            // 当天买入，故利润为负
            cache[i][0][1] = -prices[0];
        }

        // i == 0
        for (int curK = 0; curK <= k; curK++) {
            cache[0][curK][0] = 0;
            // 未开始交易，不可能持有，故无意义，取个最小值
            cache[0][curK][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int curK = 1; curK <= k; curK++) {
                // 今天未持有 = max( 昨天未持有， 昨天持有但卖掉了)
                cache[i][curK][0] = Math.max(
                        cache[i - 1][curK][0],
                        cache[i - 1][curK][1] + prices[i]
                );

                // 今天持有 = max( 昨天持有， 昨天未持有但买入)
                cache[i][curK][1] = Math.max(
                        cache[i - 1][curK][1],
                        cache[i - 1][curK - 1][0] - prices[i]
                );
            }
        }

        return cache[n - 1][k][0];
    }
}