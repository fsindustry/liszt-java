package com.fsindustry.liszt.algr.binarytree._112;

import java.util.Stack;

public class PathSum {
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

    static class Pair {
        TreeNode node;
        int sum;

        public Pair(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, targetSum));
        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            TreeNode node = top.node;
            int sum = top.sum;

            if (node.left == null && node.right == null && node.val == sum) {
                return true;
            }

            if (node.left != null) {
                stack.push(new Pair(node.left, sum - node.val));
            }

            if (node.right != null) {
                stack.push(new Pair(node.right, sum - node.val));
            }
        }

        return false;
    }
}

class Solution1 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }

        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}