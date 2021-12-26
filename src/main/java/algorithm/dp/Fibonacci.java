package algorithm.dp;

/**
 * @author Mengruo
 * @date 2021/12/18
 *
 * 通过斐波那契引出动态规划。严格来说斐波那契不算动态规划，因为不涉及到求最值，重点说明的是重叠子问题。
 * 1. 常规递归
 * 2. 备忘录递归 自顶向下
 * 3. 用dpTable 自底向上。
 *
 */
public class Fibonacci {
    /**
     * 常规递归方法，递归树的每一个节点都要计算，会造成大量的重复计算，「重叠子问题」每次都重复计算。
     * 因此如果把这些子问题的解都记录下来，下次遇到直接用，而不重复计算。见memoFib
     * @param n
     * @return
     */
    public int recursiveFib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return recursiveFib(n - 1) + recursiveFib(n - 2);
    }

    /**
     * 带备忘录的递归大大降低了时间复杂度，O(2的n次方）-> O(n)，不过这种属于自顶向下，先保存大问题的解，
     * @param n
     * @return
     */
    public int memoFib(int n) {
        // 用一个备忘录去记录每一个子问题的解
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 1;
        return memoFibCal(memo, n);
    }

    private int memoFibCal(int[] memo, int n) {
        if (memo[n] != 0) {
            return memo[n];
        }
        // 在返回之前把f(n)的值记下来 memoFibCal(memo, n - 1)里其实包含了很多memoFibCal(memo, n - 2)种已经求结果的值
        memo[n] = memoFibCal(memo, n - 1) + memoFibCal(memo, n - 2);
        return memo[n];
    }

    /**
     * 递归的自底向上解法，即动态规划。
     * 初始化第1，2项，从第3项开始，每次将前两项的值存下来，计算到第n项得出结果。
     * @param n
     * @return
     */
    public int dpTableFib(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return 1;
        // 需要保存的是前两项的值，这里也可以使用两个变量prev, cur来保存
        int[] dpTable = new int[]{1, 1};
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = dpTable[0] + dpTable[1];
            // 将dpTable更新为最近的两项
            dpTable[0] = dpTable[1];
            dpTable[1] = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.memoFib(5));
        System.out.println(fibonacci.dpTableFib(5));
    }
}
