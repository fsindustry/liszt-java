package com.fsindustry.liszt.linklist._24;

public class SwapNodesPairs {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
        int[] head = {1, 2, 3, 4};
        Solution s = new Solution();
        System.out.println("Output: " + print(s.swapPairs(build(head))));
    }

    private static void test2() {
        int[] head = {1, 2, 3};
        Solution s = new Solution();
        System.out.println("Output: " + print(s.swapPairs(build(head))));
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
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode next, n1, n2;
        while (pre.next != null && pre.next.next != null) {
            n1 = pre.next;
            n2 = pre.next.next;
            next = n2.next;
            n2.next = n1;
            n1.next = next;
            pre.next = n2;
            pre = n1;
        }
        return dummy.next;
    }
}
