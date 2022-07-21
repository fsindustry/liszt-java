package com.fsindustry.liszt.linklist5_doublepoint._234;

public class PalindromeLinkedList {
    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test1() {
        int[] head = {1, 2, 2, 1};
        Solution s = new Solution();
        System.out.println("Output: " + s.isPalindrome(build(head)));
    }

    private static void test2() {
        int[] head = {1, 2, 3, 1};
        Solution s = new Solution();
        System.out.println("Output: " + s.isPalindrome(build(head)));
    }

    private static void test3() {
        int[] head = {1};
        Solution s = new Solution();
        System.out.println("Output: " + s.isPalindrome(build(head)));
    }

    private static void test4() {
        int[] head = {1, 0, 1};
        Solution s = new Solution();
        System.out.println("Output: " + s.isPalindrome(build(head)));
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
    public boolean isPalindrome(ListNode head) {

        if (null == head || head.next == null) {
            return true;
        }
        // 拆分链表
        ListNode mid = findMid(head);
        // 翻转链表
        ListNode head2 = reverse(mid);
        // 比较
        return compare(head, head2);
    }

    public ListNode findMid(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow.next;
        slow.next = null;
        return fast;
    }

    public ListNode reverse(ListNode head) {

        if (null == head || head.next == null) {
            return head;
        }

        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public boolean compare(ListNode l1, ListNode l2) {

        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        // 因为前面已经切分，2个链表均衡，元素个数相差不超过1，故直接返回true
        return true;
    }
}