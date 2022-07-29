package com.fsindustry.liszt.stack._71;

import java.util.LinkedList;

public class SimplifyPath {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        Solution s = new Solution();
        String path = "/home/";
        System.out.println("Output: " + s.simplifyPath(path));
    }

    public static void test2() {
        Solution s = new Solution();
        String path = "/../";
        System.out.println("Output: " + s.simplifyPath(path));
    }

    public static void test3() {
        Solution s = new Solution();
        String path = "/home//foo/";
        System.out.println("Output: " + s.simplifyPath(path));
    }

    public static void test4() {
        Solution s = new Solution();
        String path = "/a//b////c/d//././/..";
        System.out.println("Output: " + s.simplifyPath(path));
    }
}

class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        for (int start = 0, i = 0; i <= path.length(); i++) {
            // 以'/'为分隔符，切词
            if (i == path.length() || path.charAt(i) == '/') {
                // 切词
                String str = path.substring(start, i);
                if (!"".equals(str)) {
                    // 若需要回退路径，则从stack中弹出上级路径
                    if ("..".equals(str)) {
                        if (stack.size() > 0) {
                            stack.pollLast();
                        }
                    }
                    // 若无需回退，则入栈
                    else if (!".".equals(str)) {
                        stack.addLast(str);
                    }
                }
                start = i + 1;
            }
        }

        // 拼接路径并返回
        StringBuilder str = new StringBuilder();
        while (stack.size() > 0) {
            str.append("/");
            str.append(stack.pollFirst());
        }
        String res = str.toString();

        // 边界条件：路径为""时，为/路径
        return "".equals(res) ? "/" : res;
    }
}