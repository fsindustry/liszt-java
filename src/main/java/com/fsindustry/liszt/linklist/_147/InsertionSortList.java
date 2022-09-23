package com.fsindustry.liszt.linklist._147;

public class InsertionSortList {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] head = {4, 2, 1, 3};
        Solution s = new Solution();
        System.out.println("Output: " + print(s.insertionSortList(build(head))));
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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        ListNode cur = head, next = null;
        while (cur != null) {

            // 遍历已经排序的链表，找到插入位置
            ListNode pre = dummy;
            ListNode sorted = dummy.next;
            while (sorted != null) {
                if (cur.val >= sorted.val) {
                    pre = sorted;
                    sorted = sorted.next;
                } else {
                    break;
                }
            }

            // 若位置在链表尾
            if (sorted == null) {
                pre.next = cur;
                next = cur.next;
                cur.next = null;
                cur = next;
            }
            // 若位置在链表头
            else {
                pre.next = cur;
                next = cur.next;
                cur.next = sorted;
                cur = next;
            }
        }

        return dummy.next;
    }
}