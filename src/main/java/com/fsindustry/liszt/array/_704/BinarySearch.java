package com.fsindustry.liszt.array._704;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class BinarySearch {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    public static void test1() {
        Solution solution = new Solution();
        int target = 9;
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println("nums: " + Arrays.toString(nums) + ", target: " + target);
        System.out.println("Output: " + solution.search(nums, target));
    }

    public static void test2() {
        Solution solution = new Solution();
        int target = 2;
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println("nums: " + Arrays.toString(nums) + ", target: " + target);
        System.out.println("Output: " + solution.search(nums, target));
    }

    public static void test3() {
        Solution solution = new Solution();
        int target = 0;
        int[] nums = {0};
        System.out.println("nums: " + Arrays.toString(nums) + ", target: " + target);
        System.out.println("Output: " + solution.search(nums, target));
    }

    public static void test4() {
        Solution solution = new Solution();
        int target = 1;
        int[] nums = {0};
        System.out.println("nums: " + Arrays.toString(nums) + ", target: " + target);
        System.out.println("Output: " + solution.search(nums, target));
    }

    public static void test5() {
        Solution solution = new Solution();
        int target = 7;
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("nums: " + Arrays.toString(nums) + ", target: " + target);
        System.out.println("Output: " + solution.search(nums, target));
    }

    public static void test6() {
        Solution solution = new Solution();
        int target = 1;
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("nums: " + Arrays.toString(nums) + ", target: " + target);
        System.out.println("Output: " + solution.search(nums, target));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        // [l, r]区间为查找的范围区间
        int l = 0, r = nums.length - 1;
        // 循环不变量：[l, r]区间为查找范围区间
        while (l <= r) {
            // 获取中间值
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
