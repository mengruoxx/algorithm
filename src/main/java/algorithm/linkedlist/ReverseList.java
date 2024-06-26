package algorithm.linkedlist;

import common.ListNode;

/**
 * @author mengruo
 * 翻转/反转链表
 *  null -> 1 -> 2 -> 3 -> 4
 *   |      |
 *  pre  cur    next
 *  每次将箭头反转，并往右边遍历
 */
public class ReverseList {

    /**
     * 假头法。新建一个假头，遍历链表将节点使用尾插法插入新链表
     * 尾插法步骤：先将头结点的next缓存下来，然后将头结点的next先指向假头的next，
     * 再将假头的next指向这个新头结点 （先连上去，再修改假头指向）
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode temp = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = temp;
        }
        return dummy.next;
    }

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
