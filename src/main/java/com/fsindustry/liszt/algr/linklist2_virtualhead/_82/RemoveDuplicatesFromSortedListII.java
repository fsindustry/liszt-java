package com.fsindustry.liszt.algr.linklist2_virtualhead._82;

public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        test1();
//        test2();
    }

    private static void test1() {
        int[] head = {1, 2, 3, 3, 4, 4, 5};
        System.out.println("Output: " + print(new Solution().deleteDuplicates(build(head))));
    }

    private static void test2() {
        int[] head = {1, 1};
        System.out.println("Output: " + print(new Solution().deleteDuplicates(build(head))));
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
        if (null == head) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            // 若发现重复节点
            if (cur.next != null && cur.val == cur.next.val) {
                // 移动cur到最后一个重复节点
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // 跳过重复节点
                pre.next = cur.next;
            } else {
                // 移动pre到下一个不删除节点
                pre = pre.next;
            }
            // 移动节点
            cur = cur.next;
        }
        return dummy.next;
    }
}