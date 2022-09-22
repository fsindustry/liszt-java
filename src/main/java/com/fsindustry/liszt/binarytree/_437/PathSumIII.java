package com.fsindustry.liszt.binarytree._437;

public class PathSumIII {
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
    public int pathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return 0;
        }

        long res = findPath(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return (int) res;
    }

    public long findPath(TreeNode node, long sum) {
        if (null == node) {
            return 0;
        }

        long res = 0;
        if (node.val == sum) {
            res += 1;
        }

        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);
        return res;
    }
}
