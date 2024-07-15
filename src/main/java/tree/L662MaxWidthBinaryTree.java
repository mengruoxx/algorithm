package tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * [662] 二叉树最大宽度
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/description/

 * Medium (39.16%)
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary
 * tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * 示例 1:
 * 输入:
 *           1
 *         /   \
 *        3     2
 *       / \     \
 *      5   3     9
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 *
 * @author mengruo
 * @date 2024/7/15 18:07
 */
public class L662MaxWidthBinaryTree {


    public static class TreeNodeNo {
        public TreeNode node;
        public int no;

        public TreeNodeNo(TreeNode node, int no) {
            this.node = node;
            this.no = no;
        }
    }


    public static int maxWidthBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNodeNo> curLevel = new LinkedList<>();
        curLevel.addLast(new TreeNodeNo(root, 1));
        int max = 0;
        while (!curLevel.isEmpty()) {
            int curWidth = curLevel.get(curLevel.size() - 1).no - curLevel.get(0).no + 1;
            if (curWidth > max) {
                max = curWidth;
            }
            LinkedList<TreeNodeNo> nextLevel = new LinkedList<>();
            while (!curLevel.isEmpty()) {
                TreeNodeNo treeNodeNo = curLevel.removeFirst();
                TreeNode node = treeNodeNo.node;
                if (node.left != null) {
                    nextLevel.add(new TreeNodeNo(node.left, treeNodeNo.no * 2));
                }
                if (node.right != null) {
                    nextLevel.add(new TreeNodeNo(node.right, treeNodeNo.no * 2 + 1));
                }
            }
            curLevel = nextLevel;
        }
        return max;
    }

}
