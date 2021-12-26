package algorithm.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mengruo
 * 动态规划
 * {@link }
 */
public class DynamicProgramming {
    /**
     * 假设你要去野营。你有一个容量为6磅的背包，需要决定该携带下面的哪些东西。
     * 其中每样东西都有相应的价值，价值越大意味着越重要，问携带哪些东西价值最高，输出最高的价值
     * •水（重3磅，价值10）：
     * •书（重1磅，价值3）
     * •食物（重2磅，价值9）
     * •夹克（重2磅，价值5）
     * •相机（重1磅，价值6）
     *
     * 实质就是用代码填充网格
     * 「状态压缩」：其实每次只需要用到表格的上一行，所以只保留上一行，而不是保存整个动态规划表格。
     *
     * @return
     */
    public int BagProblem(int capacity, int[] weight, int[] value) {
        Map<Integer, Integer> prevMaxValues = new HashMap<>(weight.length);
        for (int currentCap = 1; currentCap <= capacity; currentCap++) {
            prevMaxValues.put(currentCap, 0);
        }
        // 每一次循环代表多了一件商品可供选择 当前步骤是：weight[i], value[i];
        for (int i = 0; i < weight.length; i++) {
            // 用于记录当前步骤行
            Map<Integer, Integer> currentMaxValues = new HashMap<>(weight.length);
            for (int currentCap = 1; currentCap <= capacity; currentCap++) {
                // 不包括当前物品的最大价值
                Integer excludeCur = prevMaxValues.get(currentCap);
                // 包括当前物品的最大价值
                int includeCur = 0;
                int remainWeight = currentCap - weight[i];
                if (remainWeight >= 0) {
                    includeCur = prevMaxValues.getOrDefault(remainWeight, 0) + value[i];
                }
                // 比较二者的值，取最大记为当前步骤
                currentMaxValues.put(currentCap, Math.max(includeCur, excludeCur));
            }
            // 将当前步骤变为上一步骤
            prevMaxValues = currentMaxValues;
            System.out.println(prevMaxValues);
        }
        return prevMaxValues.get(capacity);
    }

    public static void main(String[] args) {
        DynamicProgramming dynamicProgramming = new DynamicProgramming();
        int value = dynamicProgramming.BagProblem(6, new int[]{3, 1, 2, 2, 1}, new int[]{10, 3, 9, 5, 6});
        System.out.println(value);
    }
}
