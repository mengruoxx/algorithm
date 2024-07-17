package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/submissions/
 * 修改二叉树里所有的 next 指针，使其指向右边的结点，如果右边没有结点，那么设置为空指针
 * @author mengruo
 * @date 2024/7/10 11:00
 */
public class L117NextRightPointersNode {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }

    /**
     * 使用两个list的形式
     * 先把下一层的节点存储下来，再把当前层的结点修改成一个单链表
     * @param root
     */
    public static Node nextRightPointersNode(Node root) {
        List<Node> curLevel = new ArrayList<>();
        if (root != null) {
            curLevel.add(root);
        }
        while (!curLevel.isEmpty()) {
            List<Node> nextLevel = new ArrayList<>();
            for (int i = 0; i < curLevel.size(); i++) {
                Node node = curLevel.get(i);
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                if (i == (curLevel.size() - 1)) {
                    node.next = null;
                } else {
                    node.next = curLevel.get(i + 1);
                }
            }
            curLevel = nextLevel;
        }
        return root;
    }


    public static void main(String[] args) {

    }
}
