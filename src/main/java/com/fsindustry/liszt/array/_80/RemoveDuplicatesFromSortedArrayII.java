package com.fsindustry.liszt.array._80;

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
        int count = 0;
        int k = 0; // [0,k) 存放去重后的k个元素；
        // 循环不变量：[0,k)区间为去重后元素区间，随k值增长而扩大；
        // 遍历nums，将其中元素放入[0,k)区间
        for (int i = 0; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                k++;
                if (k != i) swap(nums, k, i);
                count = 0;
            }

            if (nums[k] == nums[i] && count > 2) {
                k++;
                if (k != i) swap(nums, k, i);
                count = 0;
            } else {

                count++;
            }
        }

        return k + 1;
    }

    public void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}


