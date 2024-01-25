package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 填充二叉树的每个 next 指针，让这个指针指向其下一个右侧节点。
 * 如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * 初始状态下，所有 next 指针都被设置为 NULL
 *
 * 就是层序遍历，然后再单独遍历每一层修改next指针
 * @author mengruo
 * @date 2024/1/22 17:00
 */
public class L117NextRightPointer {

    private class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode next;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }
    }


    public TreeNode connect(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            List<TreeNode> level = new ArrayList<>();
            int levelCount = list.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = list.removeFirst();
                level.add(node);
                // 子节点入队
                if (node.left != null) {
                    list.addLast(node.left);
                }
                if (node.right != null) {
                    list.addLast(node.right);
                }
            }
            // 遍历当前层的节点，修改next指针
            for (int i = 0; i < level.size() - 1; i++) {
                level.get(i).next = level.get(i + 1);
            }
        }
        return root;
    }

}
