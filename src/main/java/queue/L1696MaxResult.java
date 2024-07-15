package queue;

import java.util.LinkedList;

/**
 * 1696. 跳跃游戏 VI
 * https://leetcode-cn.com/problems/jump-game-vi/description/
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
 * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
 * 请你返回你能得到的 最大得分
 *
 * 每一步的最大得分的滑动窗口
 * 第i个位置的最大得分，就是第i-1, i-2, ..., i-k+1个位置的最大得分中的最大值 加上i位置的得分
 *
 * @author mengruo
 * @date 2024/1/23 14:42
 */
public class L1696MaxResult {

    public static int maxResult2(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        // 定义一个数组，表示每个位置的最大得分
        int[] get = new int[nums.length];
        // 对于get[i],它应该等于它前面k个元素的最大值（相当于滑动窗口）加上num[i]
        LinkedList<Integer> list = new LinkedList<>();
        get[0] = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            // 入队，维持单调性
            while (list.size() > 0 && get[i] > list.getLast()) {
                list.removeLast();
            }
            list.add(get[i]);
            // 超出范围就出队
            if (i >= k) {
                if (get[i - k] == list.getFirst()) {
                    list.removeFirst();
                }
            }
            // 下一个位置的最大值就等于当前窗口的最大值加上下一个位置本身值
            get[i + 1] = list.getFirst() + nums[i + 1];
        }

        return get[nums.length - 1];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        maxResult2(nums, 3);
    }
}
