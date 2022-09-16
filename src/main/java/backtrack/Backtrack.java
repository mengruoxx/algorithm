package backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * abcd  acbd
 */
public class Backtrack {

    public void test(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        search(result, new ArrayList<>(), nums, new HashSet<>());

        System.out.println(result);
        System.out.println("result的大小=" + result.size());

    }

    private void search(List<List<Integer>> result, List<Integer> path, int[] nums, Set<Integer> selected) {
        // 如果已选择的元素等于数组的长度，说明已经完成一个全排列。
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素已经被选择，则跳过
            if (!selected.contains(i)) {
                // 向前搜索（有条件）
                path.add(nums[i]);
                selected.add(i);
                // 递归
                search(result, path, nums, selected);
                // 回溯（将条件撤销）
                path.remove(Integer.valueOf(nums[i]));
                selected.remove(i);
            }
        }
    }

    /**
     * 不需要元素不重复的条件的遍历，如果输入"1234"，应该输出4*4*4*4=256个结果
     * @param result
     * @param path
     * @param nums
     */
    private void searchWithNoCondition(List<String> result, String path, int[] nums) {
        // 如果已选择的元素等于数组的长度，说明已经完成一个全排列，添加到结果之中
        if (path.length() == nums.length) {
            result.add(path);
            return;
        }

        for (int num : nums) {
            /*
              因为是没有条件的搜索，所以递归之前没有条件判断，
              前进和回溯都需要有，这里的path + num相当于前进了(如果是用StringBuilder，可以将path赋值为path.append(num)传进去继续递归）
              然后递归返回之后，path还是path，相当于回退了（如果是用StringBuilder, 这里就需要将path.remove(num) 回退
              （从path + num回溯到path）
              也可以像下面这样写
              path = path + num;
              searchWithNoCondition(result, path, nums);
              path = path.substring(0, path.length()-1);
             */
            searchWithNoCondition(result, path + num, nums);
        }
    }

    public void test2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        fillElement2(result, new LinkedList<>(), nums, new HashSet<>());
//        fillElement(result, output, nums, 0, visited);

        System.out.println(result);
        System.out.println("result的大小=" + result.size());
    }

    private void fillElement(List<List<Integer>> result, List<Integer> output, int[] nums, int first, boolean[] visited) {
        if (first == nums.length) {
            result.add(new ArrayList<>(output));
            return;
        }
        for (int i = first; i < nums.length; i++) {
            // 一次循环里面代表的是 位置i之后的所有可能性（包括i）
            // 如果当前的i位置还没有被访问到
            if (!visited[first]) {
                // 前进
                visited[first] = true;
//                output.add(nums[first]);
                // 递归填充下一个位置，继续前进
                fillElement(result, output, nums, first + 1, visited);
                // 后退（撤销）
//                output.remove(nums[first]);
                visited[first] = false;
                // 然后i+1，进行下一个i之后的所有可能性的搜索
            }
        }
    }

    private void fillElement2(List<List<Integer>> result, LinkedList<Integer> output, int[] nums, Set<Integer> visited) {
        if (output.size() == nums.length) {
            result.add(new ArrayList<>(output));
            return;
        }
        for (int num : nums) {
            // 一次循环里面代表的是 位置i之后的所有可能性（包括i）
            // 如果当前的i位置还没有被访问到
            if (!visited.contains(num)) {
                // 前进
                output.addLast(num);
                visited.add(num);
                // 递归填充下一个位置，继续前进
                fillElement2(result, output, nums, visited);
                // 后退（撤销）
                output.removeLast();
                visited.remove(num);
                // 然后i+1，进行下一个i之后的所有可能性的搜索
            }
        }
    }

    public static void main(String[] args) {
        Backtrack test4 = new Backtrack();
        int[] nums = {1, 2, 3, 4};
//        test4.test2(nums);
//        test4.test(nums);

        List<String> result = new ArrayList<>();
        test4.searchWithNoCondition(result, "", nums);
        System.out.println(result);
        System.out.println("result的大小=" + result.size());

        List<Integer> a = new ArrayList<>();
        int i = a.indexOf(1);
    }
}
