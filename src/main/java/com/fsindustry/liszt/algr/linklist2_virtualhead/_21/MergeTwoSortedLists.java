package com.fsindustry.liszt.algr.linklist2_virtualhead._21;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        int[] list1 = {1, 2, 4}, list2 = {1, 3, 4};
        Solution s = new Solution();
        ListNode result = s.mergeTwoLists(build(list1), build(list2));
        System.out.println("Output: " + print(result));
    }

    private static void test2() {
        int[] list1 = {1};
        Solution s = new Solution();
        ListNode result = s.mergeTwoLists(build(list1), null);
        System.out.println("Output: " + print(result));
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        // 处理cur1和cur2都不为null的情况
        while (cur1 != null && cur2 != null) {
            if (cur1.val > cur2.val) {
                cur.next = cur2;
                cur2 = cur2.next;
            } else {
                cur.next = cur1;
                cur1 = cur1.next;
            }
            cur = cur.next;
        }

        // 处理cur1和cur2不同时为null的情况
        if (cur1 == null) {
            cur.next = cur2;
        } else {
            cur.next = cur1;
        }

        return dummy.next;
    }
}

class Solution1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = list1;
        ListNode cur2 = list2;

        // 类似链表的merge
        while (cur != null) {

            if (cur1 == null && cur2 == null) {
                break;
            }

            if (cur1 != null && cur2 == null) {
                cur.next = cur1;
                cur1 = cur1.next;
            }

            if (cur1 == null && cur2 != null) {
                cur.next = cur2;
                cur2 = cur2.next;
            }

            if (cur1 != null && cur2 != null) {
                if (cur1.val > cur2.val) {
                    cur.next = cur2;
                    cur2 = cur2.next;
                } else {
                    cur.next = cur1;
                    cur1 = cur1.next;
                }
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}

