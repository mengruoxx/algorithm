package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 例4：取出最小的数
 * 给定一个正整数数组和k，要求依次取出k个数，要求取出的k 个数字典序最小
 * 输入：nums = [3,5,2,6], k=2
 * 输出：[2,6]
 * 解释：在所有可能的解{(3,5],[3,2]，[3,6]，[5,2],[5,6]，[2,6]}中，[2,6]最小
 * @author mengruo
 * @date 2024/1/21 16:53
 */
public class NSmallNums {

    /**
     * 2024/7/9
     * 因为是依次取出，所以一旦遇到更小的数，就消掉之前比它大的数，
     * 但是不能全部消掉，如果剩余的元素都不够k个，就不能消那么多
     * @param nums
     * @param k
     * @return
     */
    public static int[] nSmallNums(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek() &&
                    (stack.size() + nums.length - i + 1) > k) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        // 最后取的是栈底的元素，多余的弹出去
        int[] result = new int[k];
        while (stack.size() > k) {
            stack.pop();
        }
        int count = stack.size();
        for (int i = 0; i < count; i++) {
            result[count - i - 1] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        assert(Arrays.equals(new int[]{1,2,3}, nSmallNums(new int[]{9,2,4,5,1,2,6,3,100,4}, 3)));
        assert(Arrays.equals(new int[]{1,2}, nSmallNums(new int[]{9,2,4,5,1,2,6,3,100,4}, 2)));
        assert(Arrays.equals(new int[]{1}, nSmallNums(new int[]{9,2,4,5,1,2,6,3,100,4}, 1)));
        assert(Arrays.equals(new int[]{1}, nSmallNums(new int[]{1,1,1,1,1}, 1)));
    }

}
