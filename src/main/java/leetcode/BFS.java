package leetcode;

import common.TreeNode;

import java.util.LinkedList;

/**
 * 二叉树的层次遍历（广度优先遍历）
 * 非递归实现：借助队列
 * 递归实现：for循环里递归
 */
public class BFS {
    /**
     * 非递归实现
     * @param root
     */
    public void BFS(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addFirst(root);
        while (list.size() > 0) {
            TreeNode item = list.getLast();
            if (item.left != null) {
                list.addFirst(item.left);
            }
            if (item.right != null) {
                list.addFirst(item.right);
            }
        }
    }

    /**
     * 递归实现
     * @param root
     */
    public void BFSRecursive(TreeNode root) {
        TreeNode left = root.left;
    }
}
