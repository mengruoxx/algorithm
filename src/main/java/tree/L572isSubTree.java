package tree;

import common.TreeNode;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/description/
 * 572. 另一棵树的子树
 * 简单
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 * @author mengruo
 * @date 2024/2/1 19:44
 */
public class L572isSubTree {

    /**
     * ***推荐***
     * 双递归解法
     * 要么root和subRoot是同一棵树，要么subRoot是左子树的子树，要么subRoot是右子树的子树
     * 本质和判断是不是同一棵树是一样的逻辑
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        // 如果他们不是同一颗树，就去检查是不是左（右）子树的子树
        return isSubtree2(root.left, subRoot) || isSubtree2(root.right, subRoot);
    }

    /**
     * 自己最初的解法
     * 思路历程：先找到和subRoot节点值相等的节点(通过遍历），然后检测以这个节点为根节点的树和subRoot结构是不是一样。
     * 如果一样返回true，如果不一样，继续这个循环
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val == subRoot.val) {
                if (isSameTree(node, subRoot)) {
                    return true;
                }
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return false;
    }

    private boolean isSameTree(TreeNode node, TreeNode subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }
        if (node == null || subRoot == null) {
            return false;
        }
        if (node.val != subRoot.val) {
            return false;
        }
        return isSameTree(node.left, subRoot.left) && isSameTree(node.right, subRoot.right);
    }


}
