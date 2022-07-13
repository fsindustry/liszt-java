package com.fsindustry.liszt.lut3._447;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Solution solution = new Solution();
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println("Output: " + solution.numberOfBoomerangs(points));
    }
}

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            // 统计每个点i，与其举例相等的点的个数
            // (距离，点的个数)
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) { // 找到不同的点
                    int distance = distance(points[i], points[j]);
                    countMap.put(distance, countMap.getOrDefault(distance, 0) + 1);
                }
            }

            // 汇总每个点i举例相等的点满足条件的个数
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                // 如果满足条件的点只有2个，则count+2
                if (entry.getValue() == 2) {
                    count += 2;
                }
                // 如果满足条件的点超过2个，则计算排列组合
                else if (entry.getValue() > 2) {
                    // 因为点的坐标有序，故为阶乘：A的n选2
                    count += entry.getValue() * (entry.getValue() - 1);
                }
            }
        }
        return count;
    }

    // 计算欧式距离，为避免小数，不开根号
    public int distance(int[] point1, int[] point2) {
        return (point2[0] - point1[0]) * (point2[0] - point1[0])
                + (point2[1] - point1[1]) * (point2[1] - point1[1]);
    }
}