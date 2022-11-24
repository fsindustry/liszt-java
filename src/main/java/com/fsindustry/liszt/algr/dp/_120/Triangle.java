package com.fsindustry.liszt.algr.dp._120;

import java.util.Arrays;
import java.util.List;

public class Triangle {
}

// dynamic search
class Solution {

    private int[][] cache;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        cache = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            cache[n - 1][i] = triangle.get(n - 1).get(i);
        }

        for (int depth = n - 2; depth >= 0; depth--) {
            for (int idx = 0; idx < triangle.get(depth).size(); idx++) {
                int left = cache[depth + 1][idx];
                int right = cache[depth + 1][idx + 1];
                cache[depth][idx] = triangle.get(depth).get(idx) + Math.min(left, right);
            }
        }

        return cache[0][0];
    }
}

// memorized search
class Solution1 {

    private int[][] cache;

    private int findMin(List<List<Integer>> triangle, int depth, int idx) {
        if (depth == triangle.size() - 1) {
            return triangle.get(depth).get(idx);
        }

        if (cache[depth][idx] == Integer.MAX_VALUE) {
            int left = findMin(triangle, depth + 1, idx);
            int right = findMin(triangle, depth + 1, idx + 1);
            cache[depth][idx] = triangle.get(depth).get(idx) + Math.min(left, right);
        }

        return cache[depth][idx];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        cache = new int[triangle.size()][triangle.size()];
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], Integer.MAX_VALUE);
        }
        return findMin(triangle, 0, 0);
    }
}