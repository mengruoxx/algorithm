package sort;

/**
 * https://leetcode.cn/problems/sort-an-array/description/
 * @author mengruo
 * @date 2024/1/25 18:05
 */
public class MergeSort {

    public void mergeSort(int[] nums) {
        // 如果传进来的数组为空
        if (nums == null || nums.length == 0) {
            return;
        }
        // temp是一个临时中转的数组
        int[] temp = new int[nums.length];
        msort(nums, 0, nums.length, temp);
    }

    private void msort(int[] nums, int left, int right, int[] temp) {
        // 空区间
        if (left >= right) {
            return;
        }
        // 空区间中只有一个结点
        if (left + 1 == right) {
            return;
        }
        // 分成两半, 二叉树可以自动取得root.left, root.right
        // 这里我们需要通过计算来得到左右子数组。
        final int mid = left + ((right - left) >> 1);

        // 类比二叉树分别遍历左子树和右子树。
        msort(nums, left, mid, temp);
        msort(nums, mid, right, temp);

        int i = left;
        int j = mid;
        int to = left;

        // 将两个子数组进行合并, 注意下面是一个很重要的模板
        while (i < mid || j < right) {
            if (j >= right || i < mid && nums[i] <= nums[j]) {
                temp[to++] = nums[i++];
            } else {
                temp[to++] = nums[j++];
            }
        }
        // 把合并的结果拷回原来的数组a[]
        for (i = left; i < right; i++) {
            nums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(new int[]{3,2,8,7,1});
    }

}
