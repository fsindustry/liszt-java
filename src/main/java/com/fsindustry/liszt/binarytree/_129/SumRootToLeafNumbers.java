package com.fsindustry.liszt.binarytree._129;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution s = new Solution();
        int sum = s.sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3)));
        System.out.println(sum);
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
    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }

        List<Integer> path = new ArrayList<>();
        return dfs(root, path);
    }

    private int dfs(TreeNode root, List<Integer> path) {
        if (null == root) {
            return 0;
        }

        path.add(root.val);
        int sum = 0;
        if (null == root.left && null == root.right) {
            sum += num(path);
        }

        if (null != root.left) {
            sum += dfs(root.left, path);
        }

        if (null != root.right) {
            sum += dfs(root.right, path);
        }
        path.remove(path.size() - 1);
        return sum;
    }

    private Integer num(List<Integer> path) {
        int num = 0;
        for (int i = 0; i < path.size(); i++) {
            num += path.get(i) * Math.pow(10, path.size() - i - 1);
        }
        return num;
    }
}
