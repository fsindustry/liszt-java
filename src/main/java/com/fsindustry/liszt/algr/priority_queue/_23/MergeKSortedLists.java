package com.fsindustry.liszt.algr.priority_queue._23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {

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
    public ListNode mergeKLists(ListNode[] lists) {
        // 边界条件1
        if (null == lists || lists.length == 0) {
            return null;
        }

        // 1）队首元素入优先队列
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparing(v -> v.val));
        for (ListNode node : lists) {
            // 边界条件2
            if (null != node) {
                queue.add(node);
            }
        }

        // 2)从多个链表的头部选择最小的元素，放入结果链表
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!queue.isEmpty()) {
            ListNode tmp = queue.poll();
            curr.next = tmp;
            curr = curr.next;
            ListNode next = tmp.next;
            if (next != null) {
                queue.add(next);
            }
        }

        return dummy.next;
    }
}