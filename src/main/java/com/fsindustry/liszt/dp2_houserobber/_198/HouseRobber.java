package com.fsindustry.liszt.dp2_houserobber._198;

import java.util.Arrays;

public class HouseRobber {
}

// dynamic program
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (0 == n) {
            return 0;
        }
        if (1 == n) {
            return nums[0];
        }

        int n1 = 0, n2 = 0, cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur = Math.max(nums[i] + n2, n1);
            n2 = n1;
            n1 = cur;
        }

        return cur;
    }
}

// dynamic program
class Solution1 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (0 == n) {
            return 0;
        }
        if (1 == n) {
            return nums[0];
        }

        int[] cache = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            cache[i] = Math.max(nums[i] + cache[i + 2], cache[i + 1]);
        }

        return cache[0];
    }
}

// memory search
class Solution2 {
    private int[] cache;

    private int dp(int[] nums, int idx) {
        if (idx >= nums.length) {
            return 0;
        }

        if (cache[idx] != -1) {
            return cache[idx];
        }

        int rob = nums[idx] + dp(nums, idx + 2);
        int not_rob = dp(nums, idx + 1);
        return cache[idx] = Math.max(rob, not_rob);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        cache = new int[n + 1];
        Arrays.fill(cache, -1);
        return dp(nums, 0);
    }
}