package com.fsindustry.liszt.algr.linklist._2;

public class AddTwoNumbers {
    public static void main(String[] args) {
        test2();
//        test1();
    }

    public static void test1() {
        Solution s = new Solution();
        int[] l1 = {2, 4, 3}, l2 = {5, 6, 4};
        System.out.println("Output: " + print(s.addTwoNumbers(build(l1), build(l2))));
    }

    public static void test2() {
        Solution s = new Solution();
        int[] l1 = {2, 4, 9}, l2 = {5, 6, 4, 9};
        System.out.println("Output: " + print(s.addTwoNumbers(build(l1), build(l2))));
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

// space cost: O(n)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode(0);
        ListNode cur = resultHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return resultHead.next;
    }
}

// space cost: O(1)
class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode result = cur1;
        ListNode pre = null;
        int carry = 0; // 存放进位
        while (cur1 != null || cur2 != null) {
            // cur1和cur2均未到达结尾
            if (cur1 != null && cur2 != null) {
                int v = cur1.val + cur2.val + carry;
                carry = v / 10;
                if (v > 9) {
                    v = v % 10;
                }
                result.val = v;
                cur1 = cur1.next;
                cur2 = cur2.next;
                result.next = cur1;
            }
            // cur1比cur2长，cur2到达结尾
            else if (cur1 != null) {
                int v = cur1.val + carry;
                carry = v / 10;
                if (v > 9) {
                    v = v % 10;
                }
                result.val = v;
                cur1 = cur1.next;
                result.next = cur1;
            }
            // cur1比cur2短，cur1到达结尾
            else {
                int v = cur2.val + carry;
                carry = v / 10;
                if (v > 9) {
                    v = v % 10;
                }

                // 注意衔接链表节点
                if (result == null) {
                    pre.next = cur2;
                    result = cur2;
                }

                result.val = v;
                cur2 = cur2.next;
                result.next = cur2;
            }
            pre = result;
            result = result.next;
        }

        // 边界情况：cur1和cur2均到达结尾，但有进位
        if (carry > 0) {
            pre.next = new ListNode(carry);
        }

        return l1;
    }
}

