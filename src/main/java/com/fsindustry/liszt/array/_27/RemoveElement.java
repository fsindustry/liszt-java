package com.fsindustry.liszt.array._27;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }

    public static void test1() {
        Solution solution = new Solution();
        int remove = 3;
        int[] arr = {3, 2, 2, 3};
        System.out.println("Input: remove: " + remove
                + ", arr: " + Arrays.toString(arr));
        System.out.println("Output: size：" + solution.removeElement(arr, remove)
                + ", arr: " + Arrays.toString(arr));
    }

    public static void test2() {
        Solution solution = new Solution();
        int remove = 2;
        int[] arr = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println("Input: remove: " + remove
                + ", arr: " + Arrays.toString(arr));
        System.out.println("Output: size：" + solution.removeElement(arr, remove)
                + ", arr: " + Arrays.toString(arr));
    }

    public static void test3() {
        Solution solution = new Solution();
        int remove = 2;
        int[] arr = {2, 2};
        System.out.println("Input: remove: " + remove
                + ", arr: " + Arrays.toString(arr));
        System.out.println("Output: size：" + solution.removeElement(arr, remove)
                + ", arr: " + Arrays.toString(arr));
    }

    public static void test4() {
        Solution solution = new Solution();
        int remove = 3;
        int[] arr = {2, 2};
        System.out.println("Input: remove: " + remove
                + ", arr: " + Arrays.toString(arr));
        System.out.println("Output: size：" + solution.removeElement(arr, remove)
                + ", arr: " + Arrays.toString(arr));
    }

    public static void test5() {
        Solution solution = new Solution();
        int remove = 3;
        int[] arr = {2, 3};
        System.out.println("Input: remove: " + remove
                + ", arr: " + Arrays.toString(arr));
        System.out.println("Output: size：" + solution.removeElement(arr, remove)
                + ", arr: " + Arrays.toString(arr));
    }

    public static void test6() {
        Solution solution = new Solution();
        int remove = 3;
        int[] arr = {3, 2};
        System.out.println("Input: remove: " + remove
                + ", arr: " + Arrays.toString(arr));
        System.out.println("Output: size：" + solution.removeElement(arr, remove)
                + ", arr: " + Arrays.toString(arr));
    }

    public static void test7() {
        Solution solution = new Solution();
        int remove = 3;
        int[] arr = {3};
        System.out.println("Input: remove: " + remove
                + ", arr: " + Arrays.toString(arr));
        System.out.println("Output: size：" + solution.removeElement(arr, remove)
                + ", arr: " + Arrays.toString(arr));
    }

}

class Solution {
    public int removeElement(int[] nums, int val) {
        // 存放下一个满足条件的元素
        int k = 0;
        // 遍历nums，将所有未被删除元素放入[0,k)区间
        // 循环不变量：[0,k)存放为删除的前k个元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                if (i != k) nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
