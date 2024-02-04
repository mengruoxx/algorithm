package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/description/
 * 98. 验证二叉搜索树
 * 中等
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author mengruo
 * @date 2024/1/25 13:54
 */
public class L98IsValidBST {

    boolean valid = true;

    List<Integer> list = new ArrayList<>();

    private long pre = Long.MIN_VALUE;

    /**
     * 检查范围
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        // 检查左节点是不是小于根节点，检查右节点是不是大于根节点，递归应用到所有子树
        preOrderCheck(root, -Long.MAX_VALUE, Long.MAX_VALUE);
        return valid;
    }

    public void preOrderCheck(TreeNode root, long min, long max) {
        if (!valid) {
            return;
        }
        if (!(root.val > min && root.val < max)) {
            valid = false;
            return;
        }

        if (root.left != null) {
            preOrderCheck(root.left, min, root.val);
        }
        if (root.right != null) {
            preOrderCheck(root.right, root.val, max);
        }
    }

    /**
     * 使用栈，实现前序遍历解
     * @param root
     * @return
     */
    public boolean preOrderStack(TreeNode root) {
        // 检查左节点是不是小于根节点，检查右节点是不是大于根节点
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node.right != null) {
//                if (node.right.val <= node.val) {
//                    return false;
//                }
//                stack.push(node.right);
//            }
//            if (node.left != null) {
//                if (node.left.val >= node.val) {
//                    return false;
//                }
//                stack.push(node.left);
//            }
//        }
//
        return true;
    }

    /**
     * 用中序遍历，注意返回值
     * @param root
     * @return
     */
    public boolean middleOrderCheck(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = middleOrderCheck(root.left);
        if (list.size() > 0 && root.val <= list.get(list.size() - 1)) {
            return false;
        }
        list.add(root.val);

        boolean right = middleOrderCheck(root.right);
        // 重点在这里，需要左右子树同时都满足
        return left && right;
    }

    /**
     * 用中序遍历，不借助list
     * @param root
     * @return
     */
    public boolean middleOrderCheck2(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = middleOrderCheck(root.left);
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        boolean right = middleOrderCheck(root.right);
        // 重点在这里，需要左右子树同时都满足
        return left && right;
    }

    /**
     * 将middleOrderCheck2优化一下，分开判断，如果左子树不满足就直接返回
     * @param root
     * @return
     */
    public boolean middleOrderCheck3(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!middleOrderCheck(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return middleOrderCheck(root.right);
    }

}
