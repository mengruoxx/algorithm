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

    /**
     * 左子树右子树高的较大值+1
     * @param root
     * @return
     */
    public int height(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean calculateTreeHeight(TreeNode root){
        int heightDiff = height(root.left) - height(root.right);
        return heightDiff <= 1 && heightDiff >= -1;
    }
}
