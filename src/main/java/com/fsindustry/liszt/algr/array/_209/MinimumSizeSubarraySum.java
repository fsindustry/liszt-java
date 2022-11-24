package com.fsindustry.liszt.algr.array._209;

import java.util.Arrays;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        Solution solution = new Solution();
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println("Input: target = " + target + ", nums = " + Arrays.toString(nums));
        System.out.println("Output: " + solution.minSubArrayLen(target, nums));
    }

    public static void test2() {
        Solution solution = new Solution();
        int target = 4;
        int[] nums = {1, 4, 4};
        System.out.println("Input: target = " + target + ", nums = " + Arrays.toString(nums));
        System.out.println("Output: " + solution.minSubArrayLen(target, nums));
    }

    public static void test3() {
        Solution solution = new Solution();
        int target = 11;
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("Input: target = " + target + ", nums = " + Arrays.toString(nums));
        System.out.println("Output: " + solution.minSubArrayLen(target, nums));
    }
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int l = 0, r = -1; // [l, r]表示当前子串
        int sum = 0; // 存放当前[l, r]子串的和
        int len = nums.length + 1;
        while (l < nums.length) {
            // 若r指针未指向末尾，且当前加和<target，则r右移，扩大窗口
            if (r < nums.length - 1 && sum < target) {
                sum += nums[++r];
            }
            // 若r指针指向末尾，或者当前加和>=target,则l右移，缩小窗口
            else {
                sum -= nums[l++];
            }

            if (sum >= target) {
                len = Math.min(len, r - l + 1);
            }
        }
        return len == nums.length + 1 ? 0 : len;
    }
}
