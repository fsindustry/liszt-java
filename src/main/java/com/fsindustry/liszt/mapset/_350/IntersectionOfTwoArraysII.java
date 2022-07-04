package com.fsindustry.liszt.mapset._350;

import java.util.*;

public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", nums2 = " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(solution.intersect(nums1, nums2)));
    }

    public static void test2() {
        Solution solution = new Solution();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", nums2 = " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(solution.intersect(nums1, nums2)));
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            Integer value = map1.get(i);
            if (value != null) {
                map1.put(i, ++value);
            } else {
                map1.put(i, 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            Integer value = map1.get(i);
            if (value != null && value > 0) {
                    result.add(i);
                map1.put(i, value - 1);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
