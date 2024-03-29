package tree;

import common.TreeNode;

/**
 * 计算树高
 * 1.树高就是层次遍历
 * 2.用递归
 * @author mengruo
 * @date 2022/7/11 16:38
 */
public class CalculateTreeHeight {
    public boolean calculateTreeHeight(TreeNode root){
        int heightDiff = height(root.left) - height(root.right);
        return heightDiff <= 1 && heightDiff >= -1;
    }

    public int height(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = height(root.left) + 1;
        int rightHeight = height(root.right) + 1;
        return Math.max(leftHeight, rightHeight);
    }
}
