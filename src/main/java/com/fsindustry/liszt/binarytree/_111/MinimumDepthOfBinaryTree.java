package com.fsindustry.liszt.binarytree._111;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MinimumDepthOfBinaryTree {
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
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (true) {
            int count = queue.size();
            if (0 == count) {
                break;
            }
            depth++;

            while (count > 0) {

                TreeNode cur = queue.poll();

                if (cur.left == null && cur.right == null) {
                    return depth;
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }

                count--;
            }
        }

        return depth;
    }
}

class Solution1 {
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        if (null == root.left && null == root.right) {
            return 1;
        }

        int res = Integer.MAX_VALUE;
        if (null != root.left) {
            res = Math.min(res, minDepth(root.left) + 1);
        }

        if (null != root.right) {
            res = Math.min(res, minDepth(root.right) + 1);
        }

        return res;
    }
}

class Solution2 {

    static class Pair {
        final TreeNode node;
        final int step;

        Pair(TreeNode node, int step) {
            this.node = node;
            this.step = step;
        }
    }

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair cur = stack.pop();

            if (cur.node.left == null && cur.node.right == null) {
                res = Math.min(res, cur.step);
            }

            if (cur.node.left != null) {
                stack.push(new Pair(cur.node.left, cur.step + 1));
            }

            if (cur.node.right != null) {
                stack.push(new Pair(cur.node.right, cur.step + 1));
            }
        }

        return res;
    }
}