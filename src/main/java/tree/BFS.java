package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层次遍历（广度优先遍历）
 * 非递归实现：借助队列
 * 递归实现：for循环里递归
 */
public class BFS {

    /**
     * 记录每一层的节点数量，二维结果
     * 使用一个链表
     * @param root
     * @return
     */
    public List<List<Integer>> BFS3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            int nodeCount = list.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < nodeCount; i++) {
                TreeNode node = list.removeFirst();
                level.add(node.getVal());
                if (node.getLeft() != null) {
                    list.addLast(node.getLeft());
                }
                if (node.getRight() != null) {
                    list.addLast(node.getRight());
                }
            }
            result.add(level);
        }
        return result;
    }

    /**
     * 使用当前层和下一层的两个指针
     * @param root
     * @return
     */
    public List<List<Integer>> BFS4(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> curLevel = new ArrayList<>();
        if (root != null) {
            curLevel.add(root);
        }
        while (!curLevel.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<>();
            List<Integer> level = new ArrayList<>();
            for (TreeNode node : curLevel) {
                level.add(node.getVal());
                if (node.getLeft() != null) {
                    nextLevel.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    nextLevel.add(node.getRight());
                }
            }
            result.add(level);
            curLevel = nextLevel;
        }
        return result;
    }

    /**
     * 简单一维结果
     * @param root
     * @return
     */
    public List<Integer> BFS2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            TreeNode node = list.removeFirst();
            result.add(node.getVal());
            if (root.left != null) {
                list.addLast(root.left);
            }
            if (root.right != null) {
                list.addLast(root.right);
            }
        }
        return result;
    }

    /**
     * 递归实现
     * @param root
     */
    public void BFSRecursive(TreeNode root) {
        TreeNode left = root.left;
    }
}
