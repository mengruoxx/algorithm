package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，
 * 并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class L1TwoSum {
    /*
    最优解法：复杂度O(n)，边遍历边存储
    遍历的过程中，将元素放入一个map中，并将value记为该元素的index，在后续遍历的过程中，
    检测（目标和 减 当前元素）是否已经存在于map中，
    如果存在，说明之前已经存在一个元素与当前元素之和=target，直接返回即可
     */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{0};
    }

    /**
     * 暴力求解法
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[]{0, 1};
        }
        // 双重循环遍历
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        // 空间换时间
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indices = map.get(nums[i]);
            if (indices != null) {
                indices.add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            // 从map中查应该存在的另一个数
            List<Integer> otherIndices = map.get(target - entry.getKey());
            // 如果应该存在的另一个数，和当前数不相等，那么只需要get出来的不为空就可以
            if (target - entry.getKey() != entry.getKey()) {
                if (otherIndices != null) {
                    return new int[]{entry.getValue().get(0), otherIndices.get(0)};
                }
            } else {
                // 如果应该存在的另一个数，当前数相等，那么get出来的必须是一个长度大于1的数组才行
                // 另一个索引是不等于当前数索引的那个值
                if (otherIndices.size() > 1) {
                    return new int[]{entry.getValue().get(0),
                            otherIndices.get(0) == entry.getValue().get(0) ? otherIndices.get(1) : otherIndices.get(0)};
                }
            }
        }
        return null;
    }


}
