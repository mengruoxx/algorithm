package tree;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/same-tree/description/
 * 100. 相同的树
 * 简单
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * @author mengruo
 * @date 2024/2/1 19:26
 */
public class L100IsSameTree {

    boolean valid = true;

    /**
     * 我最初写的解，其实这里没必要用全局变量，直接返回就行，最后会将左子树和右子树的结果&&起来
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        check(p, q);
        return valid;
    }

    public void check(TreeNode p, TreeNode q) {
        if (!valid) {
            return;
        }
        if (p == null && q != null) {
            valid = false;
            return;
        }
        if (q == null && p != null) {
            valid = false;
            return;
        }
        if (p == null && q == null) {
            return;
        }
        if (p.val != q.val) {
            valid = false;
            return;
        }
        // 检查左子树和右子树
        check(p.left, q.left);
        check(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        // 检测左右子树
        return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }
}
