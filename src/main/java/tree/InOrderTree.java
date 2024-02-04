package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树的前序遍历
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 */
public class InOrderTree {
    /**
     * 递归实现
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        inOrder(root.left);
        inOrder(root.right);
    }

    public List<Integer> inOrderStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            // 一直往左边走，直到不能入栈为止
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 出栈
            root = stack.pop();
            result.add(root.val);
            // 往右边走
            root = root.right;
        }
        return result;
    }

    /**
     * 栈写法的最优写法**
     * @param root
     * @return
     */
    public List<Integer> inOrderStack2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 从根节点开始一直往左边走入栈，然后就可以出栈，然后往右遍历一个就需要重新走这个循环
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 走到了最左边就可以把栈顶元素出栈，因为栈顶元素一定没有左孩子，注意遍历指针要重新赋值
            root = stack.pop();
            result.add(root.val);
            // 往右走一个开始下一个循环
            root = root.right;
        }
        return result;
    }

    /**
     * 更好理解的写法，看了这个写法之后就懂了上一个写法
     * @param root
     * @return
     */
    public List<Integer> inOrderStack3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 用栈实现，左子树走到最底，输出根节点，再继续遍历右子树
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // 当栈顶节点的左孩子不为空就一直进栈
        while (!stack.isEmpty()) {
            while (stack.peek().left != null) {
                stack.push(stack.peek().left);
            }
            // 然后开始出栈，栈顶的元素一定没有左孩子，所以可以将栈顶元素出栈
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                // 然后要看这个节点有没有右孩子,如果有右孩子，要将这个右孩子入栈，然后继续下一次循环
                if (node.right != null) {
                    stack.push(node.right);
                    break;
                }
            }
        }

        return result;
    }
}
