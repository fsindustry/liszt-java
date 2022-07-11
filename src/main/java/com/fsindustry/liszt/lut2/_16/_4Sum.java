package com.fsindustry.liszt.lut2._16;

import java.util.*;

public class _4Sum {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + solution.fourSum(nums, target));
    }

    public static void test2() {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + solution.fourSum(nums, target));
    }

    public static void test3() {
        Solution solution = new Solution();
        int[] nums = new int[]{100000000, 100000000, 100000000, 100000000};
        int target = Integer.MAX_VALUE;
        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + solution.fourSum(nums, target));
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Map<Long, Integer> used = new HashMap<>(nums.length);
        Set<List<Integer>> result = new HashSet<>();
        for (int a = 0; a < nums.length; a++) {
            long l1 = target - nums[a];

            // 固定a，转变为3Sum问题
            for (int b = a + 1; b < nums.length; b++) {
                long l2 = l1 - nums[b];
                // 固定b，转变为2Sum问题
                for (int c = b + 1; c < nums.length; c++) {
                    long nums_d = l2 - nums[c];

                    // 不能包含重复元素
                    if (used.containsKey(nums_d) && c != used.get(nums_d) && b != used.get(nums_d) && a != used.get(nums_d)) {
                        List<Integer> quadruplet = new ArrayList<>(4);
                        quadruplet.add(nums[a]);
                        quadruplet.add(nums[b]);
                        quadruplet.add(nums[c]);
                        quadruplet.add((int) nums_d);
                        Collections.sort(quadruplet);
                        result.add(quadruplet);

                        continue;
                    }

                    used.put((long) nums[c], c);
                }
            }
        }

        return new ArrayList<>(result);
    }
}