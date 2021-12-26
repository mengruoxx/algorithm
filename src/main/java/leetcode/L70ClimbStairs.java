package leetcode;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * @author Mengruo
 * @date 2021/12/13
 */
public class L70ClimbStairs {
    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {

        return count;
    }


    /**
     * 回溯法。n超过40就超时了。
     * 有一点像全排列，区别是选择的总次数是不一定的，最多n次，最少 n+1/2 次。每次选择的数值的总和为n
     * 还是树的结构
     *
     * @param n
     * @return r r
     */
    private static Integer count = 0;

    public int climbStairs(int n) {
        climb(n, new int[]{1, 2}, 0);
        return count;
    }

    private void climb(int n, int[] path, int sum) {
        if (sum == n) {
            count++;
            return;
        }
        for (int step : path) {
            sum = sum + step;
            // 如果此时总步数已经超过了n，就不向下搜了
            if (sum <= n) {
                // 向下搜索
                climb(n, path, sum);
            }
            sum = sum - step;
        }
    }

    public static void main(String[] args) {
        L70ClimbStairs stairs = new L70ClimbStairs();
        System.out.println(stairs.climbStairs(3));

    }
}
