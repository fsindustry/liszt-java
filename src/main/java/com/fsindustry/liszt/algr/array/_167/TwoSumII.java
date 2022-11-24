package com.fsindustry.liszt.algr.array._167;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumII {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        Solution solution = new Solution();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Input: numbers = " + Arrays.toString(numbers) + ", target = " + target);
        System.out.println("Output: " + Arrays.toString(solution.twoSum(numbers, target)));
    }

    public static void test2() {
        Solution solution = new Solution();
        int[] numbers = {2, 3, 4};
        int target = 6;
        System.out.println("Input: numbers = " + Arrays.toString(numbers) + ", target = " + target);
        System.out.println("Output: " + Arrays.toString(solution.twoSum(numbers, target)));
    }


    public static void test3() {
        Solution solution = new Solution();
        int[] numbers = {-1, 0};
        int target = -1;
        System.out.println("Input: numbers = " + Arrays.toString(numbers) + ", target = " + target);
        System.out.println("Output: " + Arrays.toString(solution.twoSum(numbers, target)));
    }

}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = numbers.length - 1; i < j; ) {
            if (numbers[i] + numbers[j] == target) {
                // 注意索引要求从1开始，而非从0开始
                return new int[]{i + 1, j + 1};
            }
            // 若二者加和大于目标值，则减小右值
            if (numbers[i] + numbers[j] > target) {
                j--;
            }
            // 若二者加和小于目标值，则增加左值
            if (numbers[i] + numbers[j] < target) {
                i++;
            }
        }
        // 题目要求必有解，若未找到解，则抛出异常
        throw new IllegalArgumentException("Invalid Result.");
    }
}
