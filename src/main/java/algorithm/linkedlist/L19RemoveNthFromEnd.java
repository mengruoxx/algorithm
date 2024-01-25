package algorithm.linkedlist;

import common.ListNode;
import common.TestUtil;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 中等
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 双指针
 * @author mengruo
 * @date 2024/1/24 19:55
 */
public class L19RemoveNthFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode front = dummy;
        ListNode back = dummy;

        for (int i = 0; i < n; i++) {
            back = back.next;
        }
        // 然后两个指针一起前进,直到back是最后一个节点
        while (back.next != null) {
            back = back.next;
            front = front.next;
        }
        // 删除front后一个节点
        front.next = front.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = TestUtil.createLinkedList(new int[]{1});
        removeNthFromEnd(head, 1);
    }
}
