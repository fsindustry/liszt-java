package com.fsindustry.liszt.array._26;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        test1();
        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
    }

    public static void test1() {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + solution.removeDuplicates(nums) + ", arr: " + Arrays.toString(nums));
    }

    public static void test2() {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + solution.removeDuplicates(nums) + ", arr: " + Arrays.toString(nums));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0; // [0,k) 存放去重后的k个元素；
        // 循环不变量：[0,k)区间为去重后元素区间，随k值增长而扩大；
        // 遍历nums，将其中元素放入[0,k)区间
        for (int i = 0; i < nums.length; i++) {
            // 找到第一个不重复的i值
            while ((i < nums.length - 1) && nums[i] == nums[i + 1]) i++;
            if (i != k) {
                swap(nums, k, i);
                k++;
            }
        }

        return k;
    }

    public void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}


