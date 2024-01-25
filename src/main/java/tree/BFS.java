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
     * 非递归实现
     * @param root
     */
    public List<List<Integer>> BFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        result.add(List.of(root.getVal()));
        while (list.size() > 0) {
            // 该层的节点个数
            int levelCount = list.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelCount; i++) {
                TreeNode item = list.removeFirst();
                if (item.left != null) {
                    list.addLast(item.left);
                    level.add(item.left.val);
                }
                if (item.right != null) {
                    list.addLast(item.right);
                    level.add(item.right.val);
                }
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
