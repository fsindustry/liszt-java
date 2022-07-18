package com.fsindustry.liszt.linklist._328;

public class OddEvenLinkedList {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Solution s = new Solution();
        int[] head = {1, 1, 2};
        System.out.println("Output: " + print(s.oddEvenList(build(head))));
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
    public ListNode oddEvenList(ListNode head) {

        // 使用两个链表，分别存放奇数和偶数
        ListNode oddHead = new ListNode(0);
        ListNode evenHead = new ListNode(0);
        ListNode odd = oddHead, even = evenHead;
        ListNode cur = head;
        int idx = 1;
        while (cur != null) {
            if (idx % 2 == 0) {
                even.next = cur;
                even = even.next;
            } else {
                odd.next = cur;
                odd = odd.next;
            }
            cur = cur.next;
            idx++;
        }

        // 拼接链表
        even.next = null;
        odd.next = evenHead.next;
        oddHead = oddHead.next;
        return oddHead;
    }
}