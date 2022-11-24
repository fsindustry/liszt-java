package com.fsindustry.liszt.algr.linklist3_doublepoint._143;

public class ReorderList {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] head = {1, 2, 3, 4};
        Solution s = new Solution();
        ListNode l = build(head);
        s.reorderList(l);
        System.out.println("Output: " + print(l));
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
    public void reorderList(ListNode head) {

        // 找中点，以便拆分前后2个链表
        ListNode mid = findMid(head);
        // 翻转后半段链表
        ListNode head2 = reverse(mid);
        // 合并2个链表
        head = merge(head, head2);
    }

    public ListNode findMid(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode merge(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;

            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }

        cur.next = (l1 == null) ? l2 : l1;

        return dummy.next;
    }
}
