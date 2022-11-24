package com.fsindustry.liszt.algr.binarytree._404;

import java.util.Stack;

public class SumOfLeftLeaves {
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {

            TreeNode top = stack.pop();
            if (top.left != null && isLeaf(top.left)) {
                sum += top.left.val;
            }

            if (top.left != null) {
                stack.push(top.left);
            }

            if (top.right != null) {
                stack.push(top.right);
            }
        }


        return sum;
    }

    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}

class Solution1 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (null == root) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        int sum = 0;
        if (root.left != null && isLeaf(root.left)) {
            sum += root.left.val;
        }

        if (root.left != null) {
            sum += sumOfLeftLeaves(root.left);
        }

        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}