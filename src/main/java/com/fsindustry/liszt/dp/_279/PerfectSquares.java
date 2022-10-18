package com.fsindustry.liszt.dp._279;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
}


// dynamic programming
class Solution {

    private int[] cache;

    public int numSquares(int n) {
        assert n >= 1;
        cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        for (int num = 1; num <= n; num++) {
            int depth = Integer.MAX_VALUE;
            for (int i = 1; num - i * i >= 0; i++) {
                depth = Math.min(depth, 1 + cache[num - i * i]);
            }
            cache[num] = depth;
        }
        return cache[n];
    }
}

// memory search
class Solution1 {

    private int[] cache;

    private int findMin(int n) {
        if (n == 0) {
            return 0;
        }

        if (cache[n] != Integer.MAX_VALUE) {
            return cache[n];
        }

        int depth = Integer.MAX_VALUE;
        for (int i = 1; n - i * i >= 0; i++) {
            depth = Math.min(depth, 1 + findMin(n - i * i));
        }
        return cache[n] = depth;
    }

    public int numSquares(int n) {
        assert n >= 1;
        cache = new int[n + 1];
        Arrays.fill(cache, Integer.MAX_VALUE);
        return findMin(n);
    }
}

// recursion: timeout
class Solution2 {

    private int findMin(int n) {
        if (n == 0) {
            return 0;
        }

        int depth = Integer.MAX_VALUE;
        for (int i = 1; n - i * i >= 0; i++) {
            depth = Math.min(depth, 1 + findMin(n - i * i));
        }
        return depth;
    }

    public int numSquares(int n) {
        assert n >= 1;
        return findMin(n);
    }
}

// BFS
class Solution3 {

    static class Pair {
        int n;
        int depth;

        public Pair(int n, int depth) {
            this.n = n;
            this.depth = depth;
        }
    }

    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n, 0));
        boolean[] visited = new boolean[n + 1];
        while (!q.isEmpty()) {
            Pair front = q.poll();

            for (int i = 1; front.n - i * i >= 0; i++) {
                int left = front.n - i * i;
                if (0 == left) {
                    return front.depth + 1;
                }

                if (!visited[left]) {
                    q.add(new Pair(left, front.depth + 1));
                }
            }
        }

        throw new IllegalArgumentException("no solution.");
    }
}