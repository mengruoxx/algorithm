package queue;

import java.util.LinkedList;

/**
 * 239 扩展
 * 滑动窗口最大值和最小值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值和最小值
 *
 * @author mengruo
 * @date 2024/1/22 18:07
 */
public class MaxAndMinSlidingWindow {

    public static int[][] maxAndMinSlidingWindow2(int[] nums, int k) {
        LinkedList<Integer> maxlist = new LinkedList<>();
        LinkedList<Integer> minlist = new LinkedList<>();
        int[][] result = new int[2][nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (maxlist.size() > 0 && nums[i] > maxlist.getLast()) {
                maxlist.removeLast();
            }
            while (minlist.size() > 0 && nums[i] < minlist.getLast()) {
                minlist.removeLast();
            }
            // 右范围边界往前移一格
            maxlist.addLast(nums[i]);
            minlist.add(nums[i]);
            if (i < k - 1) {
                // 元素个数还没到k个
                continue;
            }
            // 范围内的最大值就是队首元素的值
            result[0][i - k + 1] = maxlist.getFirst();
            result[1][i - k + 1] = minlist.getFirst();
            // 左范围边界往后移一格
            if (nums[i - k] == maxlist.getFirst()) {
                maxlist.removeFirst();
            }
            if (nums[i - k] == minlist.getFirst()) {
                minlist.removeFirst();
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};

    }
}
