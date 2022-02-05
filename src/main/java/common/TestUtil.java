package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Mengruo
 * @date 2021/12/6
 */
public class TestUtil {
    public static ListNode createLinkedList(int[] list) {
        ListNode head = new ListNode();
        ListNode cursor = head;
        for (int i = 0; i < list.length; i++) {
            ListNode node = new ListNode(list[i]);
            cursor.next = node;
            cursor = cursor.next;
        }
        return head.next;
    }
    public static void printLinkedList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        System.out.println(list);
    }

    public static TreeNode createFullTree(int[] list) {
        TreeNode root = new TreeNode(list[0]);
        TreeNode pre = root;
        boolean takeLeft = true;
        for (int i = 1; i < list.length; i++) {
            TreeNode treeNode = new TreeNode(list[i]);
            if (takeLeft) {
                pre.left = treeNode;
                takeLeft = false;
            } else {
                pre.right = treeNode;
                takeLeft = true;
                pre = pre.left;
            }
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode treeNode = queue.poll();
            list.add(treeNode.val);
            if (treeNode.left != null) {
                System.out.println(treeNode.val + "的左子树为" + treeNode.left.val);
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                System.out.println(treeNode.val + "的右子树为" + treeNode.right.val);
                queue.add(treeNode.right);
            }
        }
        System.out.println(list);
    }

}
