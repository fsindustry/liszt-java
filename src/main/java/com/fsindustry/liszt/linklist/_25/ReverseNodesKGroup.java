package com.fsindustry.liszt.linklist._25;

public class ReverseNodesKGroup {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
        int[] head = {1, 2, 3, 4, 5};
        Solution s = new Solution();
        System.out.println("Output: " + print(s.reverseKGroup(build(head), 2)));
    }

    private static void test2() {
        int[] head = {1, 2, 3, 4, 5};
        Solution s = new Solution();
        System.out.println("Output: " + print(s.reverseKGroup(build(head), 3)));
    }

    public static ListNode build(int[] headArr) {
        ListNode head = new ListNode(headArr[0]);
        ListNode curr = head;
        for (int i = 1; i < headArr.length; i++) {
            curr.next = new ListNode(headArr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static String print(ListNode head) {
        ListNode curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.val);
            sb.append(" ");
            curr = curr.next;
        }

        return sb.toString();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (null == head) {
            return null;
        }

        // 计算链表长度
        int size = 0;
        ListNode idx = head;
        while (idx != null) {
            idx = idx.next;
            size++;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, cur = head, next, con, tail;
        int count = 0, curIdx = 0;
        // 仅当剩余元素超过k个，才继续遍历翻转
        while (pre != null && size - curIdx >= k) {
            con = pre;
            tail = cur;
            pre = cur;
            cur = cur.next;
            curIdx++;

            // 翻转链表
            while (count < k - 1 && cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
                count++;
                curIdx++;
            }

            // 拼接链表
            con.next = pre;
            tail.next = cur;
            pre = tail;
            count = 0;
        }
        return dummy.next;
    }
}