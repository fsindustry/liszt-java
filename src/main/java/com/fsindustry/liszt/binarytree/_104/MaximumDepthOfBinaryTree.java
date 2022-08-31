package com.fsindustry.liszt.binarytree._104;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
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
    public int maxDepth(TreeNode root) {
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

                if (null != cur.left) {
                    queue.offer(cur.left);
                }

                if (null != cur.right) {
                    queue.offer(cur.right);
                }

                count--;
            }
        }

        return depth;
    }
}

class Solution1 {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}