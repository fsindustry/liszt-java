package com.fsindustry.liszt.algr.array._88;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();
//        test7();
    }

    public static void test1() {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", m = " + m
                + ", nums2 = " + Arrays.toString(nums2) + ", n = " + n);
        solution.merge(nums1, m, nums2, n);
        System.out.println("Output: " + Arrays.toString(nums1));
    }

    public static void test2() {
        Solution solution = new Solution();
        int[] nums1 = {1}, nums2 = {};
        int m = 1, n = 0;
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", m = " + m
                + ", nums2 = " + Arrays.toString(nums2) + ", n = " + n);
        solution.merge(nums1, m, nums2, n);
        System.out.println("Output: " + Arrays.toString(nums1));
    }

    public static void test3() {
        Solution solution = new Solution();
        int[] nums1 = {0}, nums2 = {1};
        int m = 0, n = 1;
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", m = " + m
                + ", nums2 = " + Arrays.toString(nums2) + ", n = " + n);
        solution.merge(nums1, m, nums2, n);
        System.out.println("Output: " + Arrays.toString(nums1));
    }


    public static void test4() {
        Solution solution = new Solution();
        int[] nums1 = {2, 0}, nums2 = {1};
        int m = 1, n = 1;
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", m = " + m
                + ", nums2 = " + Arrays.toString(nums2) + ", n = " + n);
        solution.merge(nums1, m, nums2, n);
        System.out.println("Output: " + Arrays.toString(nums1));
    }


    public static void test5() {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {4, 5, 6};
        int m = 3, n = 3;
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", m = " + m
                + ", nums2 = " + Arrays.toString(nums2) + ", n = " + n);
        solution.merge(nums1, m, nums2, n);
        System.out.println("Output: " + Arrays.toString(nums1));
    }

    public static void test6() {
        Solution solution = new Solution();
        int[] nums1 = {4, 5, 6, 0, 0, 0}, nums2 = {1, 2, 3};
        int m = 3, n = 3;
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", m = " + m
                + ", nums2 = " + Arrays.toString(nums2) + ", n = " + n);
        solution.merge(nums1, m, nums2, n);
        System.out.println("Output: " + Arrays.toString(nums1));
    }

}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        assert m + n > 0;
        // 边界1：若nums2数组为空，则直接返回nums1数组即可
        if (n == 0) {
            return;
        }

        // 边界2：若num1数组为空，则拷贝nums2数组元素到num1即可
        if (m == 0) {
            for (int i = 0; i < n; i++)
                nums1[i] = nums2[i];
        }

        int i = m - 1; // nums1数组的最后一个元素位置
        int j = n - 1; // nums2数组的最后一个元素位置
        int k = m + n - 1; // 存放下一个元素的索引
        // 循环不变量：(k, nums1.length]表示从小到大排列好的元素区间
        while (k > 0 && i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
            k--;
        }

        // 边界3：nums2[0]元素可能被遗漏
        for (int idx = j; idx >= 0; idx--) {
            nums1[k--] = nums2[idx];
        }
    }
}
