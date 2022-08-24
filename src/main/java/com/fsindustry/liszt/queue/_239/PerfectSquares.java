package com.fsindustry.liszt.queue._239;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {
}

class Solution {

    static class Pair {
        private final int node;
        private final int step;

        public Pair(int node, int step) {
            this.node = node;
            this.step = step;
        }
    }

    public int numSquares(int n) {
        // 边界
        if (0 == n) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(new Pair(n, 0));
        visited[n] = true;

        // 将问题转换为：从n到0的无权有向无环图最短路径问题；
        while (!queue.isEmpty()) {

            Pair pair = queue.poll();
            int num = pair.node;
            int step = pair.step;

            // 遍历所有可能节点
            for (int i = 1; pair.node - i * i >= 0; i++) {
                int left = num - i * i;
                // 若已经到达0，则表示
                if (0 == left) {
                    return step + 1;
                }
                if (!visited[left]) {
                    queue.offer(new Pair(left, step + 1));
                    visited[left] = true;
                }
            }
        }

        throw new IllegalArgumentException("no solution.");
    }
}