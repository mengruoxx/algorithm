package stack;

import java.util.Stack;

/**
 [84] 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/
 * Hard (42.74%)
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为[2,1,5,6,2,3]。
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为10个单位。
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * 给定一个数组，数组中的元素代表木板的高度
 * 请你求出相邻木板能剪出的最大矩形面积
 *
 * @author mengruo
 * @date 2024/1/21 16:30
 */
public class LargestRectangleInHistogram {

    /**
     * 2024/7/9
     * @param nums
     * @return
     */
    public int largestRectangleInHistogram2(int[] nums) {
        return 0;
    }

    /**
     * 2024/1/25
     * @param list
     * @return
     */
    public int[] largestRectangleInHistogram(int[] list) {
        int[] result = new int[list.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.length; i++) {
            // 如果当前面积，比栈中面积大，元素比栈顶元素小，就弹出栈顶并记录结果
            while (!stack.isEmpty() && list[i] < list[stack.peek()]) {
                result[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }
        // 还留在栈里的元素没有被比它小的数消除，结果为-1
        for (Integer index : stack) {
            result[index] = -1;
        }
        return result;
    }
}
