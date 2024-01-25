package queue;

import java.util.LinkedList;

/**
 * 1696. 跳跃游戏 VI

 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
 * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
 * 请你返回你能得到的 最大得分
 *
 * 每一步的最大得分的滑动窗口
 * 第i个位置的最大得分，就是第i-1, ..., i-k+1个位置的最大得分中的最大值 加上i位置的得分
 *
 * @author mengruo
 * @date 2024/1/23 14:42
 */
public class L1696MaxResult {

    public int maxResult(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer kmax = queue.getFirst();
            int currentMax = kmax + nums[i];
            // 记录到i位置的最大得分
            while (!queue.isEmpty() && currentMax > queue.getLast()) {
                queue.removeLast();
            }
            queue.add(currentMax);
            if (queue.getFirst() == temp) {
                queue.removeFirst();
            }
        }

        return 0;
    }
}
