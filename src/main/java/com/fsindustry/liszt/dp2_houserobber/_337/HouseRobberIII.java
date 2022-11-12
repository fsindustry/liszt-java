package com.fsindustry.liszt.dp2_houserobber._337;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    private Map<TreeNode, Integer> cache;

    static class Pair {
        int rob;
        int notRob;

        public Pair(int rob, int notRob) {
            this.rob = rob;
            this.notRob = notRob;
        }
    }

    private Pair dfs(TreeNode node) {
        if (null == node) {
            return new Pair(0, 0);
        }

        Pair left = dfs(node.left);
        Pair right = dfs(node.right);
        int rob = node.val + left.notRob + right.notRob;
        int notRob = Math.max(left.rob, left.notRob) + Math.max(right.rob, right.notRob);
        return new Pair(rob, notRob);
    }

    public int rob(TreeNode root) {
        if (null == root) {
            return 0;
        }
        cache = new HashMap<>();
        Pair p = dfs(root);
        return Math.max(p.notRob, p.rob);
    }
}

class Solution1 {

    private Map<TreeNode, Integer> cache;

    private int dfs(TreeNode node) {
        if (null == node) {
            return 0;
        }

        int res = cache.getOrDefault(node, -1);
        if (res != -1) {
            return res;
        }

        int rob = node.val +
                (node.left == null ? 0 : dfs(node.left.left) + dfs(node.left.right)) +
                (node.right == null ? 0 : dfs(node.right.left) + dfs(node.right.right));
        int not_rob = dfs(node.left) + dfs(node.right);
        res = Math.max(rob, not_rob);
        cache.put(node, res);
        return res;
    }

    public int rob(TreeNode root) {
        if (null == root) {
            return 0;
        }
        cache = new HashMap<>();
        return dfs(root);
    }
}