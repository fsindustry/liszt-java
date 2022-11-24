package com.fsindustry.liszt.algr.stack._20;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Solution s = new Solution();
        String str = "()";
        System.out.println("Output: " + s.isValid(str));
    }
}

class Solution {
    public boolean isValid(String s) {
        // 边界条件：考虑空字符串
        if (null == s || "".equals(s)) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 若是左括号，则入栈
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // 若是右括号，则与栈顶元素匹配；
            else {

                // 边界条件：考虑左括号少的场景
                if (stack.size() == 0) {
                    return false;
                }

                char top = stack.pop();
                char matched;
                switch (top) {
                    case '(':
                        matched = ')';
                        break;
                    case '[':
                        matched = ']';
                        break;
                    default:
                        assert top == '{';
                        matched = '}';
                        break;
                }

                if (matched != ch) {
                    return false;
                }
            }
        }

        // 边界条件：考虑左括号多的场景
        return stack.size() == 0;
    }
}