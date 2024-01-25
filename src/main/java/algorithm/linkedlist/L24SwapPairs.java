package algorithm.linkedlist;

import common.ListNode;
import common.TestUtil;

/**
 * 24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 * 中等
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * @author mengruo
 * @date 2024/1/24 17:56
 */
public class L24SwapPairs {
    /**
     * 新建两个假头链表，将奇数节点和偶数节点分别放入，再合并两个链表
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode odd = new ListNode();
        ListNode oddTail = odd;
        ListNode even = new ListNode();
        ListNode evenTail = even;
        ListNode cursor = head;
        int i = 1;
        while (cursor!= null) {
            if (i % 2 == 1) {
                oddTail.next = cursor;
                oddTail = oddTail.next;
            } else {
                evenTail.next = cursor;
                evenTail = evenTail.next;
            }
            cursor = cursor.next;
            i++;
        }
        // ***需要尾部置空！！！***
        oddTail.next = null;
        evenTail.next = null;
        // 合并
        ListNode finalHead = new ListNode();
        cursor = finalHead;

        oddTail = odd.next;
        evenTail = even.next;

        while (oddTail != null) {
            if (evenTail != null) {
                cursor.next = evenTail;
                cursor = cursor.next;
                evenTail = evenTail.next;
            }
            cursor.next = oddTail;
            oddTail = oddTail.next;
            cursor = cursor.next;
        }
        return finalHead.next;
    }

    public static void main(String[] args) {
        ListNode head = TestUtil.createLinkedList(new int[]{1, 2, 3, 4});
        swapPairs(head);
    }
}
