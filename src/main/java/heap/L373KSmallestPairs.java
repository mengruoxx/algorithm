package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 [373] 查找和最小的K对数字
 * https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/description/
 * Medium (43.37%)
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
 * 找到和最小的 k 对数字(u1,v1), (u2,v2) ... (uk,vk)。
 * 示例 1:
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * @author mengruo
 * @date 2024/7/17 18:12
 */
public class L373KSmallestPairs {

    public static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return Collections.emptyList();
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> nums1[o.i] + nums2[o.j]));
        for (int i = 0; i < nums1.length; i++) {
            queue.add(new Node(i, 0));
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Node node = queue.poll();
            result.add(List.of(nums1[node.i], nums2[node.j]));
            // 次小的一定是i+1, j,或者是i, j+1，但是因为目前i+1, j已经入堆过了，所以将i, j+1入堆
            if (node.j + 1 < nums2.length) {
                queue.add(new Node(node.i, node.j + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
    }
}
