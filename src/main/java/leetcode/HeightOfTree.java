package leetcode;

import common.TreeNode;

public class HeightOfTree {
    public int heightOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }
}
