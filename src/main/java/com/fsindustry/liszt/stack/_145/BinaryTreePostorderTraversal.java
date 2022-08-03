package com.fsindustry.liszt.stack._145;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
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
    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }
}

class Solution1 {
    enum Cmd {go, val}

    class Frame {
        private final Cmd cmd;
        private final TreeNode node;

        public Frame(Cmd cmd, TreeNode node) {
            this.cmd = cmd;
            this.node = node;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        Stack<Frame> stack = new Stack<>();
        stack.push(new Frame(Cmd.go, root));
        while (!stack.empty()) {
            Frame top = stack.pop();
            if (top.cmd == Cmd.go) {
                stack.push(new Frame(Cmd.val, top.node));
                if (top.node.right != null) {
                    stack.push(new Frame(Cmd.go, top.node.right));
                }
                if (top.node.left != null) {
                    stack.push(new Frame(Cmd.go, top.node.left));
                }
            } else {
                assert top.cmd == Cmd.val;
                result.add(top.node.val);
            }
        }

        return result;
    }
}