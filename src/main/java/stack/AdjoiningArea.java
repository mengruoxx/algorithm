package stack;

import java.util.Stack;

/**
 * 给定一个数组，数组中的元素代表木板的高度
 * 请你求出相邻木板能剪出的最大矩形面积
 *
 * @author mengruo
 * @date 2024/1/21 16:30
 */
public class AdjoiningArea {
    public int[] adjoiningArea(int[] list) {
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
