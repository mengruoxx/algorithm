package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * [1705] 吃苹果的最大数目
 * https://leetcode-cn.com/problems/maximum-number-of-eaten-apples/description/
 *
 * Medium (32.88%)
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i]
 * 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且
 * days[i] == 0 表示。
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 *
 * 示例 1：
 * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * 输出：7
 * 解释：你可以吃掉 7 个苹果：
 * - 第一天，你吃掉第一天长出来的苹果。
 * - 第二天，你吃掉一个第二天长出来的苹果。
 * - 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
 * - 第四天到第七天，你吃的都是第四天长出来的苹果。
 * @author mengruo
 * @date 2024/7/19 10:24
 */
public class L1705EatenApples {

    public static class Apple {
        int dayDue;
        int count;

        public Apple(int dayDue, int count) {
            this.dayDue = dayDue;
            this.count = count;
        }
    }

    public static int eatenApples(int[] apples, int[] days) {
        if (apples == null || days == null || apples.length == 0 || days.length == 0) {
            return 0;
        }
        // 每次吃最近会腐烂的苹果，构建一个小顶堆，按照到期的天排序
        PriorityQueue<Apple> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.dayDue));
        int eaten = 0;
        int i = 0;
        while (i < apples.length || !queue.isEmpty()) {
            if (i < apples.length && apples[i] > 0) {
                int day = days[i] + i;
                Apple newApple = new Apple(day, apples[i]);
                queue.add(newApple);
            }
            while (!queue.isEmpty()) {
                Apple apple = queue.poll();
                // 如果已经腐烂了，就选下一个
                if (apple.dayDue <= i) {
                    continue;
                }
                eaten++;
                apple.count = apple.count - 1;
                if (apple.count > 0) {
                    queue.add(apple);
                }
                break;
            }
            i++;
        }
        return eaten;
    }

    public static void main(String[] args) {
        int i = eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2});
        System.out.println(i);
    }
}
