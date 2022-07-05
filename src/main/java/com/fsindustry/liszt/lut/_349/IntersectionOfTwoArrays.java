package com.fsindustry.liszt.lut._349;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", nums2 = " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(solution.intersection(nums1, nums2)));
    }

    public static void test2() {
        Solution solution = new Solution();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println("Input: nums1 = " + Arrays.toString(nums1) + ", nums2 = " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(solution.intersection(nums1, nums2)));
    }
}

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> result = new HashSet<>();
        for (int i : nums2) {
            if (set1.contains(i)) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
