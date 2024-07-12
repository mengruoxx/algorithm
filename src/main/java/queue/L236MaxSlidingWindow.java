package queue;

import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值 困难
 * https://leetcode-cn.com/problems/sliding-window-maximum/description/
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值
 *
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * 单调队列，关键在于队头的出队条件，判断如果队头元素和刚刚滑到窗口外的元素值相等，
 * 就说明这个元素是没有被入队元素踢掉的元素，就需要出队。因为是用等值判断的，所以队列不能是严格单调的队列
 *
 * @author mengruo
 * @date 2024/1/22 18:07
 */
public class L236MaxSlidingWindow {

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (list.size() > 0 && nums[i] > list.getLast()) {
                list.removeLast();
            }
            // 右范围边界往前移一格
            list.addLast(nums[i]);
            if (i + 1 > k) {
                // 左范围边界往后移一格
                if (nums[i - k] == list.getFirst()) {
                    list.removeFirst();
                }
            }
            if (i + 1 >= k) {
                // 范围内的最大值就是队首元素的值
                result[i - k + 1] = list.getFirst();
            }
        }
        return result;
    }



    public static int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int windowIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 入队维护单调性和窗口大小
            // 将小于自己的出队，然后入队
            while (!queue.isEmpty() && queue.getLast() < num) {
                queue.removeLast();
            }
            queue.addLast(num);
            if (i < k - 1) {
                continue;
            }
            // 如果窗口超出了，要出掉一个。怎么知道超出了窗口大小？不能靠队列里的元素判断
            if (i - k >= 0 && queue.getFirst() == nums[i - k]) {
                queue.removeFirst();
            }
            // 这个时候的队首，就是当前窗口的最大值
            result[windowIndex] = queue.getFirst();
            windowIndex++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        maxSlidingWindow2(nums, 3);
    }
}
