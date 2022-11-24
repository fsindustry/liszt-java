package com.fsindustry.liszt.algr.array._26;

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

        // 若数组长度<=1，直接满足条件
        if (nums.length <= 1) {
            return nums.length;
        }

        int k = 1; // 存放下一个满足条件的元素
        // 循环不变量：[0,k)区间为去重后元素区间，随k值增长而扩大；
        // 遍历nums，将其中元素放入[0,k)区间
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}


