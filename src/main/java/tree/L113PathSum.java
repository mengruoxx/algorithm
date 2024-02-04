package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/path-sum-ii/description/
 * 113. 路径总和 II
 * 中等
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 回溯
 *
 * @author mengruo
 * @date 2024/1/25 15:58
 */
public class L113PathSum {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        search(root, 0, targetSum, currentPath, result);
        return result;
    }

    /**
     * 犯的错误：要先将节点加入路径之后，再判断是不是叶子节点要不要结束路径
     * 为什么不是检查完左树之后，回退，再检查右树？
     */
    public void search(TreeNode root, int sum, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        // 当前节点加入路径
        currentPath.add(root.val);
        sum = sum + root.val;
        // 到了叶子节点就return
        if (root.left == null && root.right == null) {
            // 搜索到叶子了，如果满足条件就加入结果
            if (sum == targetSum) {
                result.add(new ArrayList<>(currentPath));
            }
        } else {
            // 否则就要检查左树和右树
            search(root.left, sum, targetSum, currentPath, result);
            search(root.right, sum, targetSum, currentPath, result);
        }
        // 检查完左树之后，要把左节点去除掉，再走右边，回退对sum和currentPath的操作
        currentPath.remove(currentPath.size() - 1);
        sum = sum - root.val; // 不需要
    }
}
