package queue;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 [23] 合并K个升序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 * Hard (54.15%)
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *  1->4->5,
 *  1->3->4,
 *  2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * @author mengruo
 * @date 2024/7/17 11:16
 */
public class L23MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        // 复杂度klogk，k是链表的数量
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }
        // 出堆
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while (!heap.isEmpty()) {
            // 堆顶的元素
            ListNode node = heap.poll();
            ListNode temp = node;
            if (node.next != null) {
                // 将next入堆
                node = node.next;
                heap.add(node);
            }
            // temp接入链表
            head.next = temp;
            head = temp;
            temp.next = null;
        }
        return dummy.next;
    }
}
