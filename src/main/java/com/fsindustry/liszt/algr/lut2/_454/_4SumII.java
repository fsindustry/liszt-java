package com.fsindustry.liszt.algr.lut2._454;

import java.util.HashMap;
import java.util.Map;

public class _4SumII {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Solution1 solution = new Solution1();
        int[] nums1 = {1, 2}, nums2 = {-2, -1}, nums3 = {-1, 2}, nums4 = {0, 2};
        System.out.println("Output: " + solution.fourSumCount(nums1, nums2, nums3, nums4));
    }

    public static void test2() {
        Solution1 solution = new Solution1();
        int[] nums1 = {0}, nums2 = {0}, nums3 = {0}, nums4 = {0};
        System.out.println("Output: " + solution.fourSumCount(nums1, nums2, nums3, nums4));
    }
}

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int target = 0;
        // 存放(i,j)所有组合的sum，降低计算维度
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum_i_j = nums1[i] + nums2[j];
                countMap.put(sum_i_j, countMap.getOrDefault(sum_i_j, 0) + 1);
            }
        }

        // 将问题转变为3Sum问题
        // 查找所有(k,l)组合，使得 sum = target - nums3[k] - nums4[l]
        int result = 0;
        for (int k = 0; k < nums3.length; k++) {
            for (int l = 0; l < nums4.length; l++) {
                if (countMap.containsKey(target - nums3[k] - nums4[l])) {
                    result += countMap.get(target - nums3[k] - nums4[l]);
                }
            }
        }

        return result;
    }
}

class Solution1 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int target = 0;
        // 存放(i,j)所有组合的sum，降低计算维度
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum_i_j = nums1[i] + nums2[j];
                countMap.put(sum_i_j, countMap.getOrDefault(sum_i_j, 0) + 1);
            }
        }

        // 存放(k,l)所有组合的sum，降低计算维度
        Map<Integer, Integer> countMap2 = new HashMap<>();
        for (int k = 0; k < nums3.length; k++) {
            for (int l = 0; l < nums4.length; l++) {
                int sum_k_l = nums3[k] + nums4[l];
                countMap2.put(sum_k_l, countMap2.getOrDefault(sum_k_l, 0) + 1);
            }
        }

        // 将问题转变为2Sum问题
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int sum_k_l = target - entry.getKey();
            if (countMap2.containsKey(sum_k_l)) {
                result += countMap2.get(sum_k_l) * entry.getValue();
            }
        }

        return result;
    }
}