package com.fsindustry.liszt.algr.lut3._149;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Solution solution = new Solution();
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println("Output: " + solution.maxPoints(points));
    }
}

class Solution {

    /**
     * 存放斜率的分子和分母
     */
    static class Pair {
        private final int x;
        private final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (x != pair.x) return false;
            return y == pair.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public int maxPoints(int[][] points) {
        int maxCount = 1;
        // 遍历每个点points[i]，找到与点points[i]处于同一直线的所有点，并根据斜率归类
        for (int i = 0; i < points.length - 1; i++) {
            // (斜率，相同斜率点的个数(包括重复的点) )
            Map<Pair, Integer> countMap = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                // 计算斜率
                Pair pair = slope(points[i], points[j]);
                // 根据斜率，统计过点i，且处于相同直线的点的个数
                countMap.put(pair, countMap.getOrDefault(pair, 1) + 1);
                // 找过线最多的点
                maxCount = Math.max(maxCount, countMap.get(pair));
            }
        }
        return maxCount;
    }


    public Pair slope(int[] p1, int[] p2) {
        // 斜率表示：(y2-y1)/(x2-x1)
        int y = p2[1] - p1[1];
        int x = p2[0] - p1[0];


        // 若斜率为0
        if (x == 0) {
            return new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        // 若斜率不存在
        else if (y == 0) {
            return new Pair(0, 0);
        }
        // 保证x永远为正，从而保证斜率值一致
        // 比如：-2/1 和 2/-1 ，斜率一致，但x和y不同
        else if (x < 0) {
            x = -x;
            y = -y;
        }

        // 求y和x的最大公约数，将y和x根据公约数等比例缩小，从而避免y/x无法整除的情况；
        int gcd = gcd(x, y);
        return new Pair(x / gcd, y / gcd);
    }

    public int gcd(int x, int y) {
        if (x == 0) {
            return Math.abs(y);
        } else if (y == 0) {
            return Math.abs(x);
        }

        // x!=0 && y!=0
        // 我们约定最大公约数为正数
        x = Math.abs(x);
        y = Math.abs(y);
        if (x < y) {
            x = x + y;
            y = x - y;
            x = x - y;
        }
        int tmp = x % y;
        while (tmp != 0) {
            x = y;
            y = tmp;
            tmp = x % y;
        }

        return y;
    }
}
