package leetcode;

import common.TreeNode;

/**
 * 翻转二叉树
 */
public class InvertTree {
    /**
     * 从上往下翻转
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree1(root.left);
        invertTree1(root.right);
        return root;
    }

    /**
     * 从下往上翻转 时间O(n) 空间 平均O(logn)
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree2(root.left);
        TreeNode right = invertTree2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {

    }

}
