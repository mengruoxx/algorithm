package algorithm.linkedlist;

import common.ListNode;

/**
 * 合并两个有序链表
 * 定义一个元首节点，用pre指针指向它，pre是一个遍历指针，比较大小之后连接两个链表
 *           1 -> 2 -> 4 -> 7
 *  preHead
 *  pre
 *          3 -> 5 -> 8
 * 开始边界条件：任意一个为null。结束边界调节：一个链表遍历结束
 * 比较大小 修改指针 单链表前进 prev的合并链表前进
 */
public class MergeTwoLinkedList {

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            // 元首节点
            ListNode preHead = new ListNode(-1, null);
            ListNode pre = preHead;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    // 修改指针
                    pre.next = l1;
                    // 前进
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    l2 = l2.next;
                }
                // 合并后的链表前进
                pre = pre.next;
            }
            // 如果某一个链表为空，直接把另一个链表剩余的连接起来
            pre.next = l1 == null ? l2 : l1;

            return preHead.next;
        }
    }

}
