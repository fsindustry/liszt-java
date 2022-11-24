package com.fsindustry.liszt.algr.binarytree._110;

public class BalancedBinaryTree {
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
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        return height(root) != -1;
    }

    public int height(TreeNode node) {
        if (null == node) {
            return 0;
        }

        int left = height(node.left);
        if (left == -1) {
            return -1;
        }

        int right = height(node.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}

class Solution1 {
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }

        // 左右子树高度差不超过1
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // 左右子树都是平衡的
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode node) {
        if (null == node) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }
}