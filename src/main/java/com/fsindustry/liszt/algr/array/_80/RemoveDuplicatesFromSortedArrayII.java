package com.fsindustry.liszt.algr.array._80;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArrayII {

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
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + solution.removeDuplicates(nums) + ", arr: " + Arrays.toString(nums));
    }

    public static void test2() {
        Solution solution = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output: " + solution.removeDuplicates(nums) + ", arr: " + Arrays.toString(nums));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        // 数组长度<=2，直接满足条件
        if (nums.length <= 2) {
            return nums.length;
        }

        int k = 2; // 存放下一个满足条件的元素
        // 循环不变量：[0,k)区间为去重后元素区间，随k值增长而扩大；
        // 遍历nums，将其中元素放入[0,k)区间
        for (int i = 2; i < nums.length; i++) {
            // 相邻元素是否相等并无碍，故需要间隔1个元素判断
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}


