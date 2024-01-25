package algorithm.linkedlist;

import common.ListNode;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/description/
 * 876. 链表的中间结点
 * 简单
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 快慢指针
 * @author mengruo
 * @date 2024/1/24 20:22
 */
public class L876MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode front = dummy;
        ListNode back = dummy;
        while (back.next != null && back.next.next != null) {
            back = back.next.next;
            front = front.next;
        }
        return front.next;
    }

}
