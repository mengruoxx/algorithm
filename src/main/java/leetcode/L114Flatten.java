package leetcode;

import common.TestUtil;
import common.TreeNode;
import kotlin.time.TestTimeSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 */
public class L114Flatten {

    /**
     * 1. 寻找前驱节点（最优解法), o(1)空间复杂度
     * 2. （最简解法，自己的解法）将前一个节点记下来，遍历过程中不断把当前节点链到前一个节点上，借助栈，空间复杂度最多O(n)
     * 3. 单独用个链表存下所有元素，再遍历链表，空间复杂度O(n)
     */
    public void flatten3(TreeNode root) {
        /*
        前序遍历的顺序是根节点，左子树，右子树。
        展开之后，链表的第1个节点就是根节点，那么从根节点开始，根节点的下一个节点其实就是原树根节点的左子节点，
        所以就将根节点的右指针修改为原左子节点（此时相当于把左子树移到了根节点右边），那么原来的右子树应该放到哪里呢？
        当左子树遍历完成时，紧接着就会开始遍历右子树的根节点，所以右子树应该放到原左子树的最后一个节点，原左子树的最后一个
        节点是什么呢？是左子树的最右边的节点，只需要一直顺序右指针找就能找到，把原根节点右子树挂到这个节点，此时，我们就
        已经完成了链表的第1个节点的最终结构，并且也没有改变其他节点的结构，没有丢失任何一个元素，只是改变了他们的相对位置，
        接下来我们应该对链表的第2个节点，第3个节点...，完成同样的操作，链表的第2个节点就可以通过链表第1个节点找到，把我们的
        遍历指针移到这里继续操作就好了，直到到达最后一个节点。
         */
        if (root == null) {
            return;
        }
        TreeNode cur = root;
        while (cur!= null) {
            // 如果左子树为空，说明不需要展开，直接前进指针；左子树不为空才需要挂到右边
            if (cur.left != null) {
                // 找到左子树的最右节点
                TreeNode pre = cur.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 将当前节点的原右子树挂到左子树最右节点的右边
                pre.right = cur.right;
                // 将当前节点的左子树挂到右边，并将左置空
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    /**
     * 先序遍历（DFS s深度优先遍历）
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = new TreeNode();

        while (stack.size() > 0) {
            TreeNode treeNode = stack.pop();
            pre.right = treeNode;
            pre.left = null;
            System.out.println(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
            pre = treeNode;
        }
    }

    /**
     * 层序遍历，广度优先遍历
     */
    public void flatten4(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode pre = new TreeNode();
        while (queue.size() > 0) {
            TreeNode treeNode = queue.poll();
            pre.left = treeNode;
            pre.right = null;
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
            pre = treeNode;
        }
    }

    public static void main(String[] args) {
        L114Flatten flatten = new L114Flatten();
        TreeNode root = TestUtil.createFullTree(new int[]{1, 2, 3, 4, 5});
//        TestUtil.printTree(root);

        flatten.flatten(root);
        TestUtil.printTree(root);
    }
}
