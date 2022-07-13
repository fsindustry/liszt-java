package com.fsindustry.liszt.lut4._220;

import java.util.TreeSet;

public class ContainsDuplicateIII {


    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution s = new Solution();
        System.out.println("Output: " + s.containsNearbyAlmostDuplicate(new int[]{2147483640, 2147483641}, 1, 100));
    }

}


class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i] - t);
            if (ceiling != null && ceiling <= (long) nums[i] + t) {
                return true;
            } else {
                set.add((long) nums[i]);
            }

            if (set.size() == k + 1) {
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}