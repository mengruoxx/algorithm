package stack;

import java.util.Stack;

/**
 * 例2：大鱼吃小鱼 拉勾教育
 * 在水中有许多的鱼，可以认为这些鱼停放在x轴上。再给定两个数组 Size, Dir, Size[i] 表示第i条鱼的大
 * 小，Dir[i] 表示鱼的方向(0 表示向左游，1表示向右游)。这两个数组分别表示鱼的大小和游动的方向，并且这两个数组的长度相等。
 * 这些鱼的行为都符合以下几个条件：
 * 1. 所有的鱼都同时开始游动，每次按照鱼的方向，都游动一个单位距离
 * 2. 当方向相对时，大鱼会吃掉小鱼
 * 3. 鱼的大小都不一样
 * 输入：Size =[4, 2, 5, 3, 11, Dir = [1, 1, 0, 0, 0]
 * int solution (intl Size, intl Dir);
 * 输出：3  请计算还剩下几条鱼？
 * @author mengruo
 * @date 2024/1/21 15:31
 */
public class EatFish {

    /**
     * 2024/7/9
     * @param size
     * @param dir
     * @return
     */
    public int eatFish(int[] size, int[] dir) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                boolean eaten = false;
                // 方向相对才能被吃
                while (dir[i] == 0 && dir[stack.peek()] == 1) {
                    // 如果是即将入栈的鱼比较大，就消除栈里的鱼
                    if (size[i] > size[stack.peek()]) {
                        // 消除掉栈顶元素
                        stack.pop();
                    } else {
                        // 如果是栈顶的鱼比较大，就消除即将入栈的鱼
                        eaten = true;
                        break;
                    }
                }
                // 该鱼入栈
                if (!eaten) {
                    stack.push(i);
                }
            }
        }
        return stack.size();
    }

    public int eat(int[] size, int[] dir) {
        // 0: 向左游 1：向右游
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size.length; i++) {
            // 当前鱼的存活
            boolean hasEat = false;
            while (!stack.isEmpty() && dir[i] == 0 && dir[stack.peek()] == 1) {
                // 如果当前鱼是向左游，而栈顶的鱼是向右游，就会触发大鱼吃小鱼
                if (size[i] > size[stack.peek()]) {
                    // 如果当前鱼比栈顶鱼大，栈顶鱼被吃，当前鱼存活，继续和下一个栈顶鱼判断
                    stack.pop();
                } else {
                    // 当前鱼被吃，不用继续判断下一个栈顶鱼
                    hasEat = true;
                    break;
                }
            }
            if (!hasEat) {
                stack.push(i);
            }
        }

        return 0;
    }
}
