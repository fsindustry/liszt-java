package com.fsindustry.liszt.binarytree._222;

public class CountCompleteTreeNodes {
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
    public int countNodes(TreeNode root) {
        if (null == root) {
            return 0;
        }

        if (null == root.left && null == root.right) {
            return 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
