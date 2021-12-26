package leetcode;

import common.LinkedListUtil;
import common.ListNode;

/**
 * @author Mengruo
 * @date 2021/12/6
 *
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以0开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]   7 -> 0 -> 8
 *
 *   2  4  3
 *   5  6  9  9  9
 * 解释：342 + 465 = 807.
 *
 */
public class L2AddTwoNumbers {

    /**
     * 直接操作链表中的数字，而不把它转换成10进制。实际就是竖式加法，满10进1
     * 将较短的链表直接补0就好，这样只用考虑最后一位满了10需要多加一个链表元素的情况（加一个1）
     * 自己的作答，同时也是最优解
     * 但是多添加了0元素，其实不需要，如果l1已经到达尾，就不需要移动l1了，只要把它的值视为0就好，while循环条件改为只要有一个链表不为空
     * 见addTwoNumbers3
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        // 新建head，并用遍历指针指向它
        ListNode head = new ListNode();
        ListNode cursor = head;
        // 表示进位
        int carry = 0;
        while (l1 != null && l2 != null) {
            // 计算该位的和 加上进位
            int sum = l1.val + l2.val + carry;
            // 计算进位
            carry = sum / 10;
            // l3链表的元素是sum的个位
            cursor.next = new ListNode(sum % 10);
            // 前进
            cursor = cursor.next;
            // 假如一个链表已经到尾，而另一个链表还没有到尾，则在已经到尾的链表尾部添0
            if (l1.next == null && l2.next != null) {
                l1.next = new ListNode(0);
            } else if (l2.next == null && l1.next != null) {
                l2.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        // 如果此时还有进位，还需要添加一个元素
        if (carry != 0) {
            cursor.next = new ListNode(carry);
        }

        return head.next;
    }

    /**
     * 最优解
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        // 新建head，并用遍历指针指向它
        ListNode head = new ListNode();
        ListNode cursor = head;
        // 表示进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 如果其中一个链表元素已经为空了，就视为0
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            // 计算该位的和 加上进位
            int sum = val1 + val2 + carry;
            // 计算进位
            carry = sum / 10;
            // l3链表的元素是sum的个位
            cursor.next = new ListNode(sum % 10);
            // 前进
            cursor = cursor.next;
            // 没到尾才前进
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 如果此时还有进位，还需要添加一个元素
        if (carry != 0) {
            cursor.next = new ListNode(carry);
        }

        return head.next;
    }

    /**
     * 首先得到链表所表示的数，然后相加，再把数还原成链表
     * 会有溢出问题，l2元素可能很多，远超过int的表示范围
     * 测试用例：
     * [9]
     * [1,9,9,9,9,9,9,9,9,9]
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int num1 = getNumValue(l1);
        int num2 = getNumValue(l2);
        int sum = num1 + num2;
        ListNode head = new ListNode();
        ListNode prev = head;
        // 将sum还原成链表
        // 先取出低位，需要存起来，下一轮循环取出高位后，将高位的next指向刚刚的低位
        for (int i = 0; (i == 0 && sum == 0) || sum / (int) Math.pow(10, i) != 0; i++) {
            ListNode node = new ListNode();
            node.val = sum / ((int) Math.pow(10, i)) % 10;
            prev.next = node;
            prev = node;
        }
        return head.next;
    }

    /**
     * 得到链表所表示的数
     * @param head
     * @return
     */
    private int getNumValue(ListNode head) {
        int num = 0;
        for (int i = 0; head != null; i++) {
            num = num + (int) (head.val * Math.pow(10, i));
            head = head.next;
        }
        return num;
    }

    public static void main(String[] args) {
        L2AddTwoNumbers l = new L2AddTwoNumbers();
        ListNode l3 = l.addTwoNumbers2(LinkedListUtil.create(new int[]{2, 4, 3}),
                LinkedListUtil.create(new int[]{5,6,4}));
        LinkedListUtil.print(l3);
    }

}
