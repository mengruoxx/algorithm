package leetcode;

import common.TreeNode;

import java.util.Stack;

/**
 * 前序遍历
 */
public class PreOrderTree {
    /**
     * 递归实现
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 非递归实现。借助栈
     * @param root
     */
    public void preOrderNonRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (stack.size() > 0) {
            TreeNode treeNode = stack.pop();
            System.out.println(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }
}
