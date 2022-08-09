package com.fsindustry.liszt.queue._107;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (true) {
            int count = queue.size();
            if (0 == count) {
                break;
            }

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
            result.add(list);
        }
        // 翻转列表
        Collections.reverse(result);
        return result;
    }
}