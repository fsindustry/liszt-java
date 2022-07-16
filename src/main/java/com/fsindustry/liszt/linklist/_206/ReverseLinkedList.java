package com.fsindustry.liszt.linklist._206;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = build(new int[]{1, 2, 3, 4, 5});
        Solution s = new Solution();
        print(s.reverseList(head));
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
    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next; // 要翻转改变cur.next，首先要保存cur.next的引用
            cur.next = pre; // 翻转
            pre = cur; // 后移pre指针
            cur = next; // 后移cur指针
        }

        return pre;
    }
}