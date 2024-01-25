package algorithm.linkedlist;

import common.ListNode;
import common.TestUtil;

/**
 * 25. K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * 困难
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * @author mengruo
 * @date 2024/1/24 18:56
 */
public class L25ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        // 新建一个链表，尾插法插入k个为一组，然后翻转链表
        ListNode tempDummy = new ListNode();
        ListNode finalDummy = new ListNode();
        ListNode finalTail = finalDummy;
        // 遍历原链表
        ListNode p = head;
        tempDummy.next = head;
        int count = 0;
        while (p != null) {
            count++;
            // 先下移
            p = p.next;
            // 如果到达了k个
            if (count == k) {
                // 这个链表原先的头，就是最终链表当前的尾
                ListNode originalHead = tempDummy.next;
                ListNode tempHead = reverse(originalHead);
                // 尾插法插入最终链表
                finalTail.next = tempHead;
                finalTail = originalHead;
                // 重置临时链表
                tempDummy.next = p;
            }
        }
        return finalDummy.next;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode p = head;
        while (p != null) {
            p.next = dummy.next;
            dummy.next = p;
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = TestUtil.createLinkedList(new int[]{1, 2, 3, 4, 5});
        reverseKGroup(head, 2);

    }
}
