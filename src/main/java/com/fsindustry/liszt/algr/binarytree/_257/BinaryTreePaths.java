package com.fsindustry.liszt.algr.binarytree._257;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePaths {
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
    public List<String> binaryTreePaths(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }

        if (null == root.left && null == root.right) {
            return Collections.singletonList(Integer.toString(root.val));
        }

        List<String> result = new ArrayList<>();
        if (root.left != null) {
            List<String> leftPaths = binaryTreePaths(root.left);
            for (String path : leftPaths) {
                result.add(root.val + "->" + path);
            }
        }

        if (root.right != null) {
            List<String> rightPaths = binaryTreePaths(root.right);
            for (String path : rightPaths) {
                result.add(root.val + "->" + path);
            }
        }

        return result;
    }
}