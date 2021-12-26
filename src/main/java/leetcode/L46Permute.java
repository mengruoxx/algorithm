package leetcode;

import java.util.*;

/**
 * 全排列
 */
public class L46Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneCase = new ArrayList<>();

        Set<Integer> selected = new HashSet<>();
        while (selected.size() < nums.length) {
            int index = new Random().nextInt(nums.length);
            while (selected.contains(index)) {
                index = new Random().nextInt(nums.length);
                if (!selected.contains(index)) {
                    break;
                }
            }
            oneCase.add(nums[index]);
            selected.add(index);
        }
        result.add(oneCase);
        System.out.println(result);
        return null;
    }

    public static void main(String[] args) {
        L46Permute permute46 = new L46Permute();
        int[] nums = {1,2,3,4};
        permute46.permute(nums);
    }
}
