package com.fsindustry.liszt.algr.stack._144;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
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

/**
 * 递归实现
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }
}


/**
 * 通用迭代实现
 * 模拟计算机调用栈
 */
class Solution1 {

    enum Cmd {
        go,
        val
    }

    static class Frame {
        private final Cmd cmd;
        private final TreeNode node;

        public Frame(Cmd cmd, TreeNode node) {
            this.cmd = cmd;
            this.node = node;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        if (null == root) {
            return Collections.emptyList();
        }

        Stack<Frame> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        stack.push(new Frame(Cmd.go, root));
        while (!stack.empty()) {
            Frame frame = stack.pop();
            if (frame.cmd == Cmd.go) {
                if (null != frame.node.right) {
                    stack.push(new Frame(Cmd.go, frame.node.right));
                }
                if (null != frame.node.left) {
                    stack.push(new Frame(Cmd.go, frame.node.left));
                }
                stack.push(new Frame(Cmd.val, frame.node));
            } else {
                assert frame.cmd == Cmd.val;
                result.add(frame.node.val);
            }
        }
        return result;
    }
}