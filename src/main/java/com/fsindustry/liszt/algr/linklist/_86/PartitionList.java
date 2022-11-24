package com.fsindustry.liszt.algr.linklist._86;

public class PartitionList {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Solution s = new Solution();
        int[] head = {1, 4, 3, 2, 5, 2};
        System.out.println("Output: " + print(s.partition(build(head), 3)));
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
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        // 根据node.val的大小分敛node到2个链表
        ListNode cur = head;
        ListNode before = beforeHead, after = afterHead;
        while (cur != null) {
            if (cur.val < x) {
                before.next = cur;
                before = before.next;
            } else {
                after.next = cur;
                after = after.next;
            }
            cur = cur.next;
        }

        // 合并2个链表，比x小的在前，>=x的在后
        before.next = afterHead.next;
        beforeHead = beforeHead.next;
        after.next = null;
        return beforeHead;
    }
}
