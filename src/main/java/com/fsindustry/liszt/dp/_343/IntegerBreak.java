package com.fsindustry.liszt.dp._343;

import java.util.Arrays;

public class IntegerBreak {
}

// dynamic programming
class Solution {

    private int[] cache;

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int integerBreak(int n) {
        assert n >= 2;
        cache = new int[n + 1];
        Arrays.fill(cache, -1);
        for (int num = 2; num <= n; num++) {
            for (int i = 1; i <= num - 1; i++) {
                cache[num] = max3(cache[num], i * (num - i), i * cache[num - i]);
            }
        }

        return cache[n];
    }
}

// memory search
class Solution1 {

    private int[] cache;

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int breakInteger(int n) {
        if (n == 2) {
            return 1;
        }

        if (cache[n] != -1) {
            return cache[n];
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            max = max3(max, i * (n - i), i * breakInteger(n - i));
        }

        return cache[n] = max;
    }

    public int integerBreak(int n) {
        assert n >= 1;
        cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return breakInteger(n);
    }
}

// recursion: timeout
class Solution2 {

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int breakInteger(int n) {
        if (n == 2) {
            return 1;
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            max = max3(max, i * (n - i), i * breakInteger(n - i));
        }
        return max;
    }

    public int integerBreak(int n) {
        assert n >= 1;
        return breakInteger(n);
    }
}