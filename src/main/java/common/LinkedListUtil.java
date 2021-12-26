package common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mengruo
 * @date 2021/12/6
 */
public class LinkedListUtil {
    public static ListNode create(int[] list) {
        ListNode head = new ListNode();
        ListNode cursor = head;
        for (int i = 0; i < list.length; i++) {
            ListNode node = new ListNode(list[i]);
            cursor.next = node;
            cursor = cursor.next;
        }
        return head.next;
    }
    public static void print(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        System.out.println(list);
    }

}
