package com.fsindustry.liszt.algr.stack._150;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        Solution s = new Solution();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println("Output: " + s.evalRPN(tokens));
    }

    public static void test2() {
        Solution s = new Solution();
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println("Output: " + s.evalRPN(tokens));
    }

    public static void test3() {
        Solution s = new Solution();
        String[] tokens = {"4", "3", "-"};
        System.out.println("Output: " + s.evalRPN(tokens));
    }
}

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> operands = new Stack<>();
        for (String token : tokens) {
            // 如果是操作数，则入栈
            if (!"+".equals(token) &&
                    !"-".equals(token) &&
                    !"*".equals(token) &&
                    !"/".equals(token)) {
                operands.push(Integer.valueOf(token));
            }
            // 如果是操作符，则弹出操作数执行运算
            else {
                // 注1：第一个弹出的操作数是被减数 或 被除数
                // 注2：每次计算完的结果记得放回栈顶
                int o2 = 0;
                switch (token) {
                    case "+":
                        operands.push(operands.pop() + operands.pop());
                        break;
                    case "-":
                        o2 = operands.pop();
                        operands.push(operands.pop() - o2);
                        break;
                    case "*":
                        operands.push(operands.pop() * operands.pop());
                        break;
                    default:
                        assert "/".equals(token);
                        o2 = operands.pop();
                        // 边界条件：除0错误
                        if(o2 == 0){
                            throw new IllegalArgumentException("divide zero error.");
                        }
                        operands.push(operands.pop() / o2);
                        break;
                }
            }
        }

        // 最终的计算结果在栈顶
        return operands.pop();
    }
}