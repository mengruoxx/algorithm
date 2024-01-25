package algorithm.linkedlist;

import common.ListNode;

/**
 * 翻转链表
 *  null -> 1 -> 2 -> 3 -> 4
 *   |      |
 *  pre  cur    next
 *  每次将箭头反转，并往右边遍历
 */
public class ReverseList {

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            // 先把cur的next存起来，用于cur的前进
            next = cur.next;
            // 翻转
            cur.next = pre;
            // 指针前进
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rest = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }

}
