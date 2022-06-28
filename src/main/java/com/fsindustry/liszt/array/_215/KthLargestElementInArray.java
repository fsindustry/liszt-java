package com.fsindustry.liszt.array._215;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class KthLargestElementInArray {

    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
//        test4();
//        test5();
    }

    public static void test1() {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Input: nums = " + Arrays.toString(nums) + ", k = " + k);
        System.out.println("Output: " + solution.findKthLargest(nums, k));
    }

    public static void test2() {
        Solution solution = new Solution();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 5;
        System.out.println("Input: nums = " + Arrays.toString(nums) + ", k = " + k);
        System.out.println("Output: " + solution.findKthLargest(nums, k));
    }

}

class Solution {
    public int findKthLargest(int[] nums, int k) {

        int povit = nums[k]; // 要找的第K大元素的索引
        int l = 0, r = nums.length - 1; // 查找范围的左右边界，闭区间；

        // 循环不变量：[l, k)存放所有小于povit的元素
        // 循环不变量：（k, r]存放所有大于povit的元素
        while (l < r) {
            // 在[l, k)区间查找比povit大的元素索引
            while (l < r && nums[l] < povit) l++;
            // 在(k, r]区间查找比povit小的元素索引
            while (l < r && nums[r] > povit) r--;
            // 交换2个元素的位置
            if (l < r) {
                swap(nums, l, r);
            }
        }

        nums[k] = nums[r];
        nums[r] = povit;

        return r;
    }


    public void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
