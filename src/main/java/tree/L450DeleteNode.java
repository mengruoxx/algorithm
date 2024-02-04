package tree;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 * 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。
 * 返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * @author mengruo
 * @date 2024/1/25 17:04
 */
public class L450DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode p = root;
        while (p != null) {
            if (key == p.val) {
                // 删除

                return root;
            } else if (key > p.val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return null;
    }
}
