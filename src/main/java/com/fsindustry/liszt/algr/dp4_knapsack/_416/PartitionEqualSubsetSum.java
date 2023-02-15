package com.fsindustry.liszt.algr.dp4_knapsack._416;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        Solution s = new Solution();
        int[] nums = {1, 5, 11, 5};
        boolean res = s.canPartition(nums);
        System.out.println(res);
    }

    static void test2() {
        Solution s = new Solution();
        int[] nums = {1, 2, 3, 5};
        boolean res = s.canPartition(nums);
        System.out.println(res);
    }

    static void test3() {
        Solution s = new Solution();
        int[] nums = {1, 2, 5};
        boolean res = s.canPartition(nums);
        System.out.println(res);
    }
}

// dp: space cost preference
class Solution {

    private int[] cache;

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 > 0) {
            return false;
        }

        int C = sum / 2;
        cache = new int[C + 1];
        Arrays.fill(cache, 0);
        cache[0] = btoi(true);
        for (int i = 0; i < n; i++) {
            for (int c = C; c >= 0; c--) {
                if (c - nums[i] >= 0) {
                    cache[c] = btoi(itob(cache[c]) || itob(cache[c - nums[i]]));
                }
            }
        }

        return itob(cache[C]);
    }

    private boolean itob(int src) {
        if (src == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int btoi(boolean src) {
        if (src) {
            return 1;
        } else {
            return 0;
        }
    }
}

// dp1
class Solution1 {

    private int[][] cache;

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 > 0) {
            return false;
        }

        int C = sum / 2;
        cache = new int[n][C + 1];
        for (int[] a : cache) {
            Arrays.fill(a, -1);
        }


        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= C; c++) {
                if (i == 0) {
                    cache[0][c] = btoi(nums[i] == c);
                    continue;
                }

                if (c == 0) {
                    cache[i][0] = btoi(true);
                    continue;
                }

                if (c - nums[i] >= 0) {
                    cache[i][c] = btoi(itob(cache[i - 1][c]) || itob(cache[i - 1][c - nums[i]]));
                } else {
                    cache[i][c] = cache[i - 1][c];
                }
            }
        }

        return itob(cache[n - 1][C]);
    }

    private boolean itob(int src) {
        if (src == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int btoi(boolean src) {
        if (src) {
            return 1;
        } else {
            return 0;
        }
    }
}

// memory search
class Solution2 {

    private int[][] cache;

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n <= 0) {
            return false;
        }
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 > 0) {
            return false;
        }

        int C = sum / 2;
        cache = new int[n][C + 1];
        for (int[] a : cache) {
            Arrays.fill(a, -1);
        }
        // 对于第n-1个物品，判断其容量累积是否为sum
        return dp(nums, n - 1, C);
    }

    private boolean dp(int[] nums, int idx, int cap) {
        if (cap == 0) { // 容量为0，表示恰好容纳
            return true;
        }

        if (cap < 0 || idx < 0) { // 若越界，则说明无法恰好容纳
            return false;
        }

        if (cache[idx][cap] != -1) {
            return itob(cache[idx][cap]);
        }

        // 2种选择：不放入第idx个物品 或者 放入第idx个物品
        boolean res = dp(nums, idx - 1, cap) || dp(nums, idx - 1, cap - nums[idx]);
        cache[idx][cap] = btoi(res);
        return res;
    }

    private boolean itob(int src) {
        if (src == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int btoi(boolean src) {
        if (src) {
            return 1;
        } else {
            return 0;
        }
    }
}