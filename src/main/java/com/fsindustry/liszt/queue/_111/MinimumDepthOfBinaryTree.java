package com.fsindustry.liszt.queue._111;

import java.util.LinkedList;
import java.util.Queue;

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

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (true) {
            int count = queue.size();
            if (count == 0) {
                break;
            }
            depth++;

            boolean got = false;
            while (count > 0) {
                TreeNode head = queue.poll();

                if (head.left == null && head.right == null) {
                    got = true;
                    break;
                }

                if (null != head.left) {
                    queue.offer(head.left);
                }

                if (null != head.right) {
                    queue.offer(head.right);
                }

                count--;
            }

            if (got) {
                break;
            }
        }
        return depth;
    }
}