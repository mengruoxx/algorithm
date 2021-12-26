package algorithm.greedy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Mengruo
 * 贪心算法
 */
public class Greedy {
    /**
     * 每个广播台只能覆盖一定数量的周，求解用最小的广播台数量，覆盖全部的州。
     *
     * 贪心：每次都选择能覆盖最多的未覆盖的州的广播台，直到全部覆盖。
     * 因为需要有一个数据结构保存当前已覆盖的州。
     * @param toBeCovered
     * @param coverList
     * @return
     */
    public int leastBoardcast(Set<Integer> toBeCovered, Map<String, Set<Integer>> coverList) {
        // 当前已覆盖的州
        Set<Integer> covered = new HashSet<>();
        // 已选择广播台的数量
        int count = 0;
        // 知道toBeCovered为空为止
        while (toBeCovered.size() != 0) {
            String target = "";
            int coverMaxNum = 0;
            // 每次选出覆盖最多的
            for (Map.Entry<String, Set<Integer>> entry : coverList.entrySet()) {
                // 求covers和 beBeCovered的交集的元素个数，即为当前广播站能覆盖的个数
                int coverNum = coverNum(entry.getValue(), toBeCovered);
                if (coverNum > coverMaxNum) {
                    coverMaxNum = coverNum;
                    target = entry.getKey();
                }
            }
            // 如果已经没有州能覆盖还未覆盖的州，说明没有解，返回0
            if (coverMaxNum == 0) {
                return 0;
            }
            // 选出之后，移除toBeCovered，移除map里的该广播站
            toBeCovered.removeAll(coverList.get(target));
            coverList.remove(target);
            count++;
        }
        return count;
    }

    private int coverNum(Set<Integer> covers, Set<Integer> toBeCovered) {
        int count = 0;
        for (Integer element : covers) {
            if (toBeCovered.contains(element)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        Greedy greedy = new Greedy();
//        Set<Integer> integers = Set.of(1, 2, 3);
//        greedy.leastBoardcast(Set.of(1, 2, 3),
//                Map.of("a", Set.of(1, 2),
//                        "b", Set.of(2, 3)));
    }
}
