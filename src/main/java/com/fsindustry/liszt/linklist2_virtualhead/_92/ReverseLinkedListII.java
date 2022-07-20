package com.fsindustry.liszt.linklist2_virtualhead._92;


public class ReverseLinkedListII {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    public static void test1() {
        ListNode head = build(new int[]{1, 2, 3, 4, 5});
        Solution s = new Solution();
        print(s.reverseBetween(head, 2, 4));
    }

    public static void test2() {
        ListNode head = build(new int[]{1, 2, 3, 4, 5});
        Solution s = new Solution();
        print(s.reverseBetween(head, 1, 3));
    }

    public static void test3() {
        ListNode head = build(new int[]{1, 2, 3, 4, 5});
        Solution s = new Solution();
        print(s.reverseBetween(head, 3, 5));
    }

    public static void test4() {
        ListNode head = build(new int[]{5});
        Solution s = new Solution();
        print(s.reverseBetween(head, 1, 1));
    }

    public static void test5() {
        ListNode head = build(new int[]{3, 5});
        Solution s = new Solution();
        print(s.reverseBetween(head, 1, 1));
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

    public static void print(ListNode head) {
        ListNode curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.val);
            sb.append(" ");
            curr = curr.next;
        }

        System.out.println(sb);
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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (null == head) {
            return null;
        }

        // 找到翻转的起始位置
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (left > 1) {
            pre = cur;
            cur = cur.next;
            left--;
            right--;
        }

        // 翻转指定区间节点
        ListNode con = pre;
        ListNode tail = cur;
        ListNode next = null;
        while (right > 0 && cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            right--;
        }

        // 拼接链表
        con.next = pre;
        tail.next = cur;

        return dummy.next;
    }
}