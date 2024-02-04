package tree;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
 * 树的后序遍历
 */
public class PostOrderTree {
    /**
     * 递归实现
     * @param root
     */
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

    public List<Integer> postOrderNonRecursive1(TreeNode root) {
        return null;
    }

    @Data
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        boolean hasPop;

        public boolean isHasPop() {
            return hasPop;
        }

        public void setHasPop(boolean hasPop) {
            this.hasPop = hasPop;
        }
    }

    /**
     * 非递归实现。借助栈 死循环写法 错误
     * @param root
     */
    public List<Integer> postOrderNonRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> hasPop = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            // 左右子节点入栈
            boolean push = false;
            if (node.right != null && !hasPop.contains(node.right)) {
                stack.push(node.right);
                push = true;
            }
            if (node.left != null && !hasPop.contains(node.left)) {
                stack.push(node.left);
                push = true;
            }
            if (!push) {
                node = stack.pop();
                hasPop.add(node);
                result.add(node.val);
            }
        }
        return result;
    }

}
