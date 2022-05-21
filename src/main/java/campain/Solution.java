package campain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mengruo
 * @date 2022/2/5 22:46
 */
public class Solution {
    public int minimumSum(int num) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int number = num % 10;
            nums.add(number);
            num = (num - number) / 10;
        }

        int min = 9999;
        for (int i = 0; i < nums.size(); i++) {
//            int minNum = ;
            for (int j = 0; j < nums.size() - 1; j++) {

            }
            int sum = search(nums);
            if (sum < min) {
                min = sum;
            }
        }

        return min;
    }

    int search(List<Integer> nums) {
        return 0;
    }
}
