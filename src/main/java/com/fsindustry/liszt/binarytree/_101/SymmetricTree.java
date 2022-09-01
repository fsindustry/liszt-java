package com.fsindustry.liszt.binarytree._101;

import java.util.Stack;

public class SymmetricTree {
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

    static class Frame {
        TreeNode left;
        TreeNode right;

        public Frame(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }

        Stack<Frame> stack = new Stack<>();
        stack.push(new Frame(root.left, root.right));
        while (!stack.isEmpty()) {
            Frame cur = stack.pop();
            TreeNode left = cur.left;
            TreeNode right = cur.right;

            if (null == left && null == right) {
                continue;
            }

            if (null == left || null == right) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            stack.push(new Frame(left.left, right.right));
            stack.push(new Frame(left.right, right.left));
        }

        return true;
    }
}

class Solution1 {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }

        if (null == left || null == right) {
            return false;
        }

        return (left.val == right.val)
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }
}
