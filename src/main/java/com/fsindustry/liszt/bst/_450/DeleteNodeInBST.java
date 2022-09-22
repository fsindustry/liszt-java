package com.fsindustry.liszt.bst._450;

public class DeleteNodeInBST {
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (null == root.left) {
                root = root.right;
            } else if (null == root.right) {
                root = root.left;
            } else {
                TreeNode min = findMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }
}