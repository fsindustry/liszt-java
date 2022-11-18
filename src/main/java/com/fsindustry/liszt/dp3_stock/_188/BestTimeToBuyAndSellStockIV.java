package com.fsindustry.liszt.dp3_stock._188;

public class BestTimeToBuyAndSellStockIV {
}


class Solution {

    private int maxProfitUnlimitK(int[] prices) {
        int i0 = 0, i1 = -prices[0];
        for (int price : prices) {
            i0 = Math.max(i0, i1 + price);
            i1 = Math.max(i1, i0 - price);
        }
        return i0;
    }

    private int maxProfitLimitK(int K, int[] prices) {
        int n = prices.length;
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

    public int maxProfit(int K, int[] prices) {
        if (null == prices || 0 == prices.length) {
            return 0;
        }

        if (K > prices.length / 2) {
            return maxProfitUnlimitK(prices);
        } else {
            return maxProfitLimitK(K, prices);
        }
    }
}