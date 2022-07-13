package com.fsindustry.liszt.lut4._219;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
        Solution s = new Solution();
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println("" + s.containsNearbyDuplicate(nums, k));
    }

    private static void test2() {
        Solution s = new Solution();
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        System.out.println("" + s.containsNearbyDuplicate(nums, k));
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }

            // 若i，j之间长度超过k，则缩小窗口
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}