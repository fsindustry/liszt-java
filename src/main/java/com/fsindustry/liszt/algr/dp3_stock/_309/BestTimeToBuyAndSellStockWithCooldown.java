package com.fsindustry.liszt.algr.dp3_stock._309;

public class BestTimeToBuyAndSellStockWithCooldown {
}

class Solution {
    public int maxProfit(int[] prices) {
        if (null == prices || 0 == prices.length) {
            return 0;
        }

        int n = prices.length;
        int cooldown = 2;
        int i0 = 0, i1 = -prices[0], ipre = 0;
        for (int i = 0; i < n; i++) {
            int tmp = i0;
            i0 = Math.max(i0, i1 + prices[i]);
            i1 = Math.max(i1, ipre - prices[i]);
            ipre = tmp;
        }
        return i0;
    }
}

class Solution1 {
    public int maxProfit(int[] prices) {
        if (null == prices || 0 == prices.length) {
            return 0;
        }

        int n = prices.length;
        int cooldown = 2;
        int[][] cache = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (0 == i) {
                cache[0][0] = 0;
                cache[0][1] = -prices[i];
                continue;
            }

            if (i - cooldown == -1) {
                cache[i][0] = Math.max(cache[i - 1][0], cache[i - 1][1] + prices[i]);
                cache[i][1] = Math.max(cache[i - 1][1], -prices[i]);
                continue;
            }
            cache[i][0] = Math.max(cache[i - 1][0], cache[i - 1][1] + prices[i]);
            cache[i][1] = Math.max(cache[i - 1][1], cache[i - cooldown][0] - prices[i]);
        }
        return cache[n - 1][0];
    }
}