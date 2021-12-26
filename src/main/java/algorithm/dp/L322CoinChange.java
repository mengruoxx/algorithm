package algorithm.dp;

import java.util.Arrays;

/**
 * @author Mengruo
 * @date 2021/12/18
 *
 * 322. 零钱兑换
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * 示例 1：
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 *
 *      * 硬币面值： c1,c2,c3,...,ci
 *      *
 *      * f(s) = f(s-c) + 1  （s是金额，c是硬币面值。
 *      * 如果f(s)是金额为s时的硬币最小数量，我们要思考子问题的最优解和f(s)的关系，子问题即f(s-x)，那么x等于多少呢？
 *      当前问题f(s)可以由f(s-c1),f(s-c2),...,f(s-ci) 加上一转移而来，它的值就是这些之中的最小值
 *      * 也可以反过来思考，假如我们已经知道了f(s)的值，那下一步我们就能知道f(s+？)的值？
 *      * 很显然，金额要多一点，那肯定数量最少要多一个，面值又是确定的，那么就可以确定f(s+c1), f(s+c2),...,f(s+ci)
 *      * 每一个f(s)都可以由f(s-c1),f(s-c2),...,f(s-ci)确定，有i个可能值，需要选择最小的那一个。
 *      * f(3) = y -> f(4) = y+1, f(5)=x+1, f(8)= y+1
 *      * f(6) = x -> f(7) = x+1, f(8)=x+1, f(11)=x+1
 * 两种方法，其本质是一样的：
 * 1. 备忘录递归（dp函数） 2. 动态规划（dp数组）
 * 3. 按面值排序+剪枝：https://leetcode-cn.com/problems/coin-change/solution/322-by-ikaruga/
 */
public class L322CoinChange {

    /**
     * 方法二：dp数组动态规划
     * 基于coinChange3的小优化
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange4(int[] coins, int amount) {
        // dp数组依次记录结果
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int curAmount = 1; curAmount <= amount; curAmount++) {
            for (int coinValue : coins) {
                if (curAmount - coinValue >= 0) {
                    // 保存dp[curAmount]对应的值，如果无解，值就是amount+1，返回的时候再判断
                    dp[curAmount] = Math.min(dp[curAmount - coinValue] + 1, dp[curAmount]);
                }
            }
        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }

    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int curAmount = 1; curAmount <= amount; curAmount++) {
            int result = amount + 1;
            for (int coinValue : coins) {
                if (curAmount - coinValue < 0 || dp[curAmount - coinValue] == -1) continue;
                result = Math.min(dp[curAmount - coinValue] + 1, result);
            }
            dp[curAmount] = result == (amount + 1) ? -1 : result;
        }
        return dp[amount];
    }

    /**
     * 方法一：备忘录递归
     * 基于coinChange1
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        // 用一个数组将子结果记录下来，避免重复递归计算
        int[] memo = new int[amount+1];
        Arrays.fill(memo, amount + 1);
        return memoRecursive(coins, amount, memo);
    }

    private int memoRecursive(int[] coins, int amount, int[] memo) {
        // base case
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        // 如果在备忘录里找到，直接返回
        if (memo[amount] < amount + 1) return memo[amount];
        // result为f(amount - coin)中最小的
        int result = amount + 1;
        for (int coinValue : coins) {
            // amount -coinValue为负数，跳过 XXX 子问题无解，跳过，不比较
//            if (amount - coinValue < 0) continue;
            int subResult = memoRecursive(coins, amount - coinValue, memo);
            if (subResult == -1) continue;
            result = Math.min(subResult + 1, result);
        }
        // 返回之前保存到备忘录,注意判断这个结果的有效性, 如果无解，需要保存-1
        memo[amount] = result == (amount + 1) ? -1 : result;
        return memo[amount];
    }

    /**
     * 不带备忘录的递归：重复计算了
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        // base case
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        // result为f(amount - coin)中最小的
        int result = 0;
        for (int coinValue : coins) {
            // amount -coinValue为负数，跳过
            if (amount - coinValue < 0) continue;
            int subResult = coinChange1(coins, amount - coinValue);
            if (subResult + 1 < result) {
                result = subResult + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        L322CoinChange l322CoinChange = new L322CoinChange();
        System.out.println(l322CoinChange.coinChange4(new int[]{1, 2, 5}, 11));
    }
}
