package com.fsindustry.liszt.array._283;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeros {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    public static void test1(){
        Solution solution = new Solution();
        int[] arr = {0, 1, 0, 3, 12};
        System.out.println("Input: " + Arrays.toString(arr));
        solution.moveZeroes(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }

    public static void test2(){
        Solution solution = new Solution();
        int[] arr = {0};
        System.out.println("Input: " + Arrays.toString(arr));
        solution.moveZeroes(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }

    public static void test3(){
        Solution solution = new Solution();
        int[] arr = {0, 0};
        System.out.println("Input: " + Arrays.toString(arr));
        solution.moveZeroes(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }

    public static void test4(){
        Solution solution = new Solution();
        int[] arr = {0, 0, 1};
        System.out.println("Input: " + Arrays.toString(arr));
        solution.moveZeroes(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }

    public static void test5(){
        Solution solution = new Solution();
        int[] arr = {1, 0, 0};
        System.out.println("Input: " + Arrays.toString(arr));
        solution.moveZeroes(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        // [0,k)存放数组中所有非0元素；
        int k = 0;
        // 遍历nums，将不为0的元素与[0,k)区间中为0的元素交换位置
        // 循环不变量：[0,k)为不为0的元素区间
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != k) swap(nums, k, i);
                k++;
            }
        }
    }

    public void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
