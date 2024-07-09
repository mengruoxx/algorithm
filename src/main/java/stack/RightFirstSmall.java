package stack;

import java.util.Stack;

/**
 * ### 找出数组中右边比我小的元素：小数消除大数
 *
 * > 一个整数数组 A，找到每个元素：右边第一个比我小的下标位置，没有则用-1 表示
 * 输入：[5,2]  输出：[1,-1]
 * >
 * @author mengruo
 * @date 2024/1/21 16:30
 */
public class RightFirstSmall {

    /**
     * 2024/7/9
     * @param list
     * @return
     */
    public int[] rightFirstSmall2(int[] list) {
        int[] result = new int[list.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.length; i++) {
            while (!stack.isEmpty() && list[i] < list[stack.peek()]) {
                Integer index = stack.pop();
                result[index] = i;
            }
            stack.push(i);
        }
        for (Integer i : stack) {
            result[i] = -1;
        }
        return result;
    }




    public int[] rightFirstSmall(int[] list) {
        int[] result = new int[list.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < list.length; i++) {
            // 如果当前元素比栈顶元素小，就弹出栈顶并记录结果
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
