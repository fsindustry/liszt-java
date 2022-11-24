package com.fsindustry.liszt.algr.bst._230;

public class KthSmallestElementInBST {
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

    private int idx = 0;

    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestNode(root, k).val;
    }

    public TreeNode kthSmallestNode(TreeNode node, int k) {

        if (null == node) {
            return null;
        }

        TreeNode res = kthSmallestNode(node.left, k);
        if (res != null) {
            return res;
        }

        if (++idx == k) {
            return node;
        }

        return kthSmallestNode(node.right, k);
    }
}