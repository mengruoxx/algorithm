package heap;

import java.util.PriorityQueue;

/**
 * [1642] 可以到达的最远建筑
 * https://leetcode-cn.com/problems/furthest-building-you-can-reach/description/
 * Medium (47.92%)
 *
 * 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。
 * 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
 * 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：
 * 如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
 * 如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
 * 如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
 * 示例 1：
 * 输入：heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
 * 输出：4
 * 解释：从建筑物 0 出发，你可以按此方案完成旅程：
 * - 不使用砖块或梯子到达建筑物 1 ，因为 4 >= 2
 * - 使用 5 个砖块到达建筑物 2 。你必须使用砖块或梯子，因为 2 < 7
 * - 不使用砖块或梯子到达建筑物 3 ，因为 7 >= 6
 * - 使用唯一的梯子到达建筑物 4 。你必须使用砖块或梯子，因为 6 < 9
 * 无法越过建筑物 4 ，因为没有更多砖块或梯子。
 * @author mengruo
 * @date 2024/7/18 16:26
 */
public class L1642FurthestBuilding {

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> diffQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                diffQueue.add(diff);
                // 先用砖块
                bricks = bricks - diff;
                // 如果砖块够就进入下一步
                if (bricks < 0) {
                    // 如果砖块不够了，就将落差最高的用梯子代替
                    // 注意这里要先将当前的diff入堆（前面已经先入堆了），当前的diff也应该在比较的范围
                    if (ladders > 0) {
                        // 把砖块还回来
                        if (!diffQueue.isEmpty()) {
                            bricks = bricks + diffQueue.poll();
                            ladders--;
                        }
                    } else {
                        // 梯子也不够了，输出
                        return i - 1;
                    }
                }
            }
        }
        return heights.length - 1;
    }

    public static void main(String[] args) {
        int i = furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1);
    }

}
