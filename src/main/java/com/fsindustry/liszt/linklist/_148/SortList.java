package com.fsindustry.liszt.linklist._148;

public class SortList {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] head = {4, 2, 1, 3};
        Solution s = new Solution();
        System.out.println("Output: " + print(s.sortList(build(head))));
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 获取中间节点
        ListNode head2 = getMid(head);
        // 分别排序左右链表
        ListNode left = sortList(head);
        ListNode right = sortList(head2);
        // 归并左右链表
        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;
        return head2;
    }

    private ListNode merge(ListNode head, ListNode head2) {

        if (null == head && null == head2) {
            return null;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        while (head != null && head2 != null) {
            if (head.val < head2.val) {
                cur.next = head;
                cur = cur.next;
                head = head.next;
                cur.next = null;
            } else {
                cur.next = head2;
                cur = cur.next;
                head2 = head2.next;
                cur.next = null;
            }
        }

        if (head == null) {
            cur.next = head2;
        } else {
            cur.next = head;
        }

        return dummy.next;
    }
}
