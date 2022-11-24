package com.fsindustry.liszt.algr.dp2_houserobber._213;

public class HouseRobberII {
}


class Solution {
    private int dp(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }

        int n1 = 0, n2 = 0, cur = 0;
        for (int i = end; i >= start; i--) {
            cur = Math.max(nums[i] + n2, n1);
            n2 = n1;
            n1 = cur;
        }

        return cur;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (0 == n) {
            return 0;
        }
        if (1 == n) {
            return nums[0];
        }
        return Math.max(
                dp(nums, 0, n - 2),
                dp(nums, 1, n - 1)
        );
    }
}