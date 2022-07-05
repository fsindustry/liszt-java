package com.fsindustry.liszt.mapset._1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // ( nums[i], i )
        Map<Integer, Integer> used = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int expect = target - nums[i];
            if (used.containsKey(expect)) {
                return new int[]{i, used.get(expect)};
            }

            used.put(nums[i], i);
        }
        throw new IllegalArgumentException("no solution.");
    }
}