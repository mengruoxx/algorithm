package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * [347] 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 * Medium (61.87%)
 *
 * 给定一个非空的整数数组，返回其中出现频率前k高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 你可以假设给定的k总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) ,n是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案
 * @author mengruo
 * @date 2024/7/16 14:58
 */
public class L347TopKFrequent {

    /**
     * 要先将map维护完
     * 我的错误解答：不能边统计次数边入堆，会有重复的元素入堆
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        // 堆中的元素对应的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        // 小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        map.forEach((num, count) -> {
            if (heap.size() < k) {
                heap.add(num);
            } else {
                if (count > map.get(heap.element())) {
                    heap.poll();
                    heap.add(num);
                }
            }
        });
        return heap.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1,0};
        topKFrequent(nums, 1);
    }
}
