package com.fsindustry.liszt.linklist._83;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Solution s = new Solution();
        int[] head = {1, 1, 2};
        System.out.println("Output: " + print(s.deleteDuplicates(build(head))));
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
    public ListNode deleteDuplicates(ListNode head) {

        ListNode cur = head;
        while (cur != null) {
            // 跳过重复节点
            if (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}