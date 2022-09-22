package com.fsindustry.liszt.bst._98;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution s = new Solution();
        s.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3)));
    }
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

    private List<Integer> values = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }

        inOrderTraverse(root);
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i - 1) >= values.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void inOrderTraverse(TreeNode root) {
        if (null == root) {
            return;
        }

        inOrderTraverse(root.left);
        values.add(root.val);
        inOrderTraverse(root.right);
    }
}

class Solution2 {
    static class Frame {
        TreeNode node;
        int min;
        int max;

        public Frame(TreeNode node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }

        Stack<Frame> stack = new Stack<>();
        stack.push(new Frame(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        while (!stack.isEmpty()) {
            Frame frame = stack.pop();

            if (frame.node.val < frame.min || frame.node.val > frame.max) {
                return false;
            }

            if (frame.node.left != null) {
                if (frame.node.val <= frame.node.left.val) {
                    return false;
                }
                stack.push(new Frame(frame.node.left, frame.min, frame.node.val - 1));
            }

            if (frame.node.right != null) {
                if (frame.node.val >= frame.node.right.val) {
                    return false;
                }
                stack.push(new Frame(frame.node.right, frame.node.val + 1, frame.max));
            }
        }

        return true;
    }
}

class Solution1 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, int min, int max) {
        if (null == root) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }

        if (root.left != null && root.val <= root.left.val) {
            return false;
        }

        if (root.right != null && root.val >= root.right.val) {
            return false;
        }

        return isValidBST(root.left, min, root.val - 1) && isValidBST(root.right, root.val + 1, max);
    }
}