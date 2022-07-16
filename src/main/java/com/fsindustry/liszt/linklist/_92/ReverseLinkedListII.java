package com.fsindustry.liszt.linklist._92;

public class ReverseLinkedListII {

    public static void main(String[] args) {
        test5();
//        test4();
//        test3();
//        test2();
//        test1();
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

        // 找到left位置节点，使得pre = node[left]
        ListNode start = null; // left的前一个位置
        ListNode pre = null; // left所在位置
        ListNode cur = head; // 当前遍历位置
        int i = 1;
        for (; i <= left; i++) {
            start = pre;
            pre = cur;
            cur = cur.next;
        }

        // 翻转链表，直至pre = node[right]或者cur==null
        ListNode next = cur;
        for (; i <= right && cur != null; i++) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 重新链接翻转后的链表
        if (null == start) { // 若从头结点开始翻转
            start = head;
            start.next = next;
            head = pre;
        } else { // 若不从头结点开始翻转
            cur = start.next;
            start.next = pre;
            cur.next = next;
        }

        return head;
    }
}