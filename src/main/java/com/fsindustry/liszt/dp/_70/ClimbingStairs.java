package com.fsindustry.liszt.dp._70;

import java.util.Arrays;

public class ClimbingStairs {
}

// dynamic programming
class Solution {
    private int[] cache;

    public int climbStairs(int n) {
        cache = new int[n + 1];
        Arrays.fill(cache, -1);

        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}


// memorized search
class Solution1 {
    private int[] cache;

    private int calCount(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        if (cache[n] == -1) {
            cache[n] = calCount(n - 1) + calCount(n - 2);
        }

        return cache[n];
    }

    public int climbStairs(int n) {
        cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return calCount(n);
    }
}