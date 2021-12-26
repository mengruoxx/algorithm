package leetcode;

import common.TreeNode;

/**
 * 前序遍历
 */
public class PreOrderTree {
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
