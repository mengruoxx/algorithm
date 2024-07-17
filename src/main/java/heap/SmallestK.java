package heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的 k 个数
 * 给定一个数组 a[]，返回这个数组中最小的 k 个数。
 * 输入：A = [3,2,1], k = 2
 * 输出：[2, 1]
 *
 * @author mengruo
 * @date 2024/7/16 10:34
 */
public class SmallestK {
    /**
     * 使用大顶堆，复杂度nlogk
     * @param stock
     * @param cnt
     * @return
     */
    public int[] smallestK(int[] stock, int cnt) {
        if (stock == null || cnt == 0) {
            return new int[0];
        }

        // 大顶堆
        Queue<Integer> queue = new PriorityQueue<>(stock.length, ((o1, o2) -> o2 - o1));
        for (int i = 0; i < stock.length; i++) {
            if (i + 1 <= cnt) {
                queue.add(stock[i]);
            } else {
                if (stock[i] < queue.element()) {
                    queue.poll();
                    queue.add(stock[i]);
                }
            }
        }

        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}
