package com.fsindustry.liszt.linklist3_doublepoint._61;

public class RotateList {
    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int[] head = {1, 2, 3, 4, 5};
        Solution s = new Solution();
        System.out.println("Output: " + print(s.rotateRight(build(head), 2)));
    }

    private static void test2() {
        int[] head = {0, 1, 2};
        Solution s = new Solution();
        System.out.println("Output: " + print(s.rotateRight(build(head), 4)));
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
    public ListNode rotateRight(ListNode head, int k) {

        if (null == head) {
            return null;
        }

        // 当k > len时，需要缩减k，避免重复翻转整个链表
        int len = getLen(head);
        k = k % len;

        // 找到翻转起始位置
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        for (int i = 0; i < k + 1; i++) {
            if (fast.next == null) {
                fast = dummy;
            } else {
                fast = fast.next;
            }
        }

        // 移动slow和fast，使得二者间隔k
        ListNode slow = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 移动元素到链表头
        ListNode con = dummy;
        ListNode tail = slow;
        slow = slow.next;
        ListNode tmp = null;
        while (slow != null) {
            tmp = slow.next;
            slow.next = con.next;
            con.next = slow;
            slow = tmp;
            con = con.next;
        }
        tail.next = null;

        return dummy.next;
    }

    public int getLen(ListNode listNode) {
        int i = 0;
        while (listNode != null) {
            listNode = listNode.next;
            i++;
        }
        return i;
    }
}