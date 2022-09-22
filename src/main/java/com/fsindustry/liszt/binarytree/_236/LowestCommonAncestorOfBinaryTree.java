package com.fsindustry.liszt.binarytree._236;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfBinaryTree {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution s = new Solution();
        TreeNode res = s.lowestCommonAncestor(new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(1), new TreeNode(3));
        System.out.println(res.val);
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }

}


class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        assert (null != root && null != p && null != q);

        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        dfs(root, p, pPath);
        dfs(root, q, qPath);

        TreeNode res = null;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i) == qPath.get(i)) {
                res = pPath.get(i);
            } else {
                break;
            }
        }

        return res;
    }

    private boolean dfs(TreeNode node, TreeNode target, List<TreeNode> path) {
        if (null == node) {
            return false;
        }

        path.add(node);
        if (node.val == target.val) {
            return true;
        }

        if (dfs(node.left, target, path)) {
            return true;
        }

        if (dfs(node.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}