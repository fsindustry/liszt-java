package com.fsindustry.liszt.queue._103;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (true) {
            int count = queue.size();
            if (0 == count) {
                break;
            }
            level++;

            List<Integer> list = new ArrayList<>();
            while (count > 0) {

                TreeNode head = queue.poll();
                list.add(head.val);

                if (null != head.left) {
                    queue.offer(head.left);
                }

                if (null != head.right) {
                    queue.offer(head.right);
                }

                count--;
            }

            if (level % 2 == 0) {
                Collections.reverse(list);
            }

            result.add(list);
        }

        return result;
    }
}