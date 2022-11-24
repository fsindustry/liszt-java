package com.fsindustry.liszt.algr.linklist3_doublepoint._19;

public class RemoveNthNodeFromEndList {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int[] head = {1, 2, 3, 4, 5};
        Solution s = new Solution();
        System.out.println("Output: " + print(s.removeNthFromEnd(build(head), 2)));
    }

    private static void test2() {
        int[] head = {1, 2};
        Solution s = new Solution();
        System.out.println("Output: " + print(s.removeNthFromEnd(build(head), 1)));
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // fast指针先移动
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        // slow和fast保持n个间距移动
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
