package com.fsindustry.liszt.binarytree._113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathSumII {
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, result, path);
        return result;
    }

    public void dfs(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {
        if(null == root){
            return;
        }

        if (isLeaf(root) && targetSum == root.val) {
            List<Integer> res = new ArrayList<>(path);
            res.add(root.val);
            result.add(res);
        }

        path.add(root.val);
        dfs(root.left, targetSum - root.val, result, path);
        dfs(root.right, targetSum - root.val, result, path);
        path.remove(path.size() - 1);
    }

    boolean isLeaf(TreeNode node) {
        return null == node.left && null == node.right;
    }
}