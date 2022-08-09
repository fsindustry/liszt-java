package com.fsindustry.liszt.queue._199;

import java.util.*;

public class BinaryTreeRightSideView {
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
    public List<Integer> rightSideView(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (true) {
            int count = queue.size();
            if (0 == count) {
                break;
            }

            while (count > 0) {
                TreeNode head = queue.poll();
                if (count == 1) {
                    result.add(head.val);
                }

                if (null != head.left) {
                    queue.offer(head.left);
                }

                if (null != head.right) {
                    queue.offer(head.right);
                }

                count--;
            }
        }
        return result;
    }
}