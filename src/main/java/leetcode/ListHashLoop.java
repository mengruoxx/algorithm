package leetcode;

import common.ListNode;

/**
 * 判断链表是否有环
 * 快慢指针法
 */
public class ListHashLoop {
    public boolean hasLoop(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
