package com.fsindustry.liszt.algr.queue._102;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (true) {
            // 获取下一层需要处理的节点数
            int count = queue.size();
            if (0 == count) { // 若待处理节点为0，则表示完成遍历
                break;
            }

            List<Integer> subList = new ArrayList<>();
            while (count > 0) {


                // 处理当前层级的节点值
                TreeNode head = queue.poll();
                subList.add(head.val);

                // 将下一层级的节点入队
                if (null != head.left) {
                    queue.offer(head.left);
                }

                if (null != head.right) {
                    queue.offer(head.right);
                }

                count--;
            }

            result.add(subList);
        }

        return result;
    }
}