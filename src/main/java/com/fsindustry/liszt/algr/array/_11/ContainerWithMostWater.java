package com.fsindustry.liszt.algr.array._11;

import java.util.Arrays;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        Solution solution = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Input: " + Arrays.toString(height));
        System.out.println("Output: " + solution.maxArea(height));
    }

    public static void test2() {
        Solution solution = new Solution();
        int[] height = {1, 1};
        System.out.println("Input: " + Arrays.toString(height));
        System.out.println("Output: " + solution.maxArea(height));
    }

    public static void test3() {
        Solution solution = new Solution();
        int[] height = {1, 2, 1};
        System.out.println("Input: " + Arrays.toString(height));
        System.out.println("Output: " + solution.maxArea(height));
    }

}


class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(maxArea, area);
            // 不断地调整左右两条边，使得2条边保持最长的组合
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}