package com.fsindustry.liszt.mapset._15;

import java.util.*;

public class _3Sum {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println("Input: nums = " + Arrays.toString(nums));
        System.out.println("Output: " + solution.threeSum(nums));
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Map<Integer, Integer> used = new HashMap<>(nums.length);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];

            // 转变为two sum问题
            for (int j = i + 1; j < nums.length; j++) {
                int left2 = left - nums[j];
                // 不能包含重复元素
                if (used.containsKey(left2) && j != used.get(left2) && i != used.get(left2)) {
                    List<Integer> tuple = new ArrayList<>(3);
                    tuple.add(nums[i]);
                    tuple.add(nums[j]);
                    tuple.add(left2);
                    Collections.sort(tuple);
                    result.add(tuple);
                    continue;
                }

                used.put(nums[j], j);
            }
        }

        return new ArrayList<>(result);
    }
}