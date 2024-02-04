package tree;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/description/
 * 501. 二叉搜索树中的众数
 * 简单
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * 示例 1：
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * 示例 2：
 * 输入：root = [0]
 * 输出：[0]
 * @author mengruo
 * @date 2024/2/1 20:48
 */
public class L501FindMode {

    /**
     * 思路：返回众数可以用中序遍历，
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        return null;
    }

}
