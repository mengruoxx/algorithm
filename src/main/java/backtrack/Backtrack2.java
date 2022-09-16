package backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// 题解参考「爱学习的饲养员」
class Backtrack2 {
    // 回溯算法「状态重置」「月光宝盒」
    public List<List<Integer>> permute(int[] nums) {
        // 定义返回结果集
        List<List<Integer>> result = new ArrayList<>();
        // 初始化HashMap，key为num，value为该数字是否已使用
        // value为false表示该数字未被使用
        HashMap<Integer, Boolean> visitedMap = new HashMap<>(nums.length);
        for (int num : nums) {
            visitedMap.put(num, false);
        }
        backtrack(nums, result, visitedMap, new LinkedList<>());
        System.out.println(result);
        System.out.println("result的大小=" + result.size());
        return result;
    }

    /**
     * 回溯法「状态重置」「暴力搜索的变种算法」
     */
    public void backtrack(int[] nums, List<List<Integer>> result,
                          HashMap<Integer, Boolean> visitedMap, LinkedList<Integer> list) {
        // 判断List是否已经达到满足答案的长度
        if (list.size() == nums.length) {
            // 注意！此处需要重新new一个List实现，然后进行赋值
            // 因为不重新构造List进行赋值，那么在回溯过程中，由于引用的存在，依旧会将list的元素进行移除，这样最终得到的结果就是为[]
            result.add(new ArrayList<>(list));
            return;
        }

        // 开始遍历数组数字
        for (int num : nums) {
            // 去哈希表中检查当前数字是否已使用
            // false表示该数字未被使用
            if (!visitedMap.get(num)) {
                // 将当前数字添加到list中
                list.addLast(num);
                // 更新哈希表中关于该数字的使用状态
                visitedMap.put(num, true);
                // 再次进行backtrack，以当前数字为基础进行排列
                backtrack(nums, result, visitedMap, list);
                // 当结束上面的backtrack时，说明基于当前数字进行的回溯已经结束
                // 移除list中的元素
                // 因为List存放的是数字，所以不能直接使用num进行删除，否则调用的是另外一个重载方法
                list.removeLast();
                visitedMap.put(num, false);
            }
        }
    }

    public static void main(String[] args) {
        Backtrack2 backtrack2 = new Backtrack2();
        int[] nums = {1, 2, 3, 4};
        backtrack2.permute(nums);
    }
}
