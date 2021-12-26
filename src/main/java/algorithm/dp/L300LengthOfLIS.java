package algorithm.dp;

/**
 * @author Mengruo
 * @date 2021/12/19
 *
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */
public class L300LengthOfLIS {
    /**
     * 自己的思路：
     * 1. base case：
     * 2. 状态：变化的量，数组的长度
     * 3. 选择：选择一个元素导致长度fashengbinahua发生变化
     * 4. 关系：f(n)是最长递增子序列的长度，n是数组的长度，ru
     *     找到了f(n),f(n+1) = f(n) + 1 (如果nums[n-1] > 最长递增子序列的最后一个元素）
     *                      = f(n)
     *
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        return 0;
    }
}
