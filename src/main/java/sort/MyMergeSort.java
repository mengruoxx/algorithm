package sort;

/**
 * https://leetcode.cn/problems/sort-an-array/description/
 * @author mengruo
 * @date 2024/1/25 18:05
 */
public class MyMergeSort {

    public int[] mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        msort(nums, 0, nums.length, temp);
        return nums;
    }

    /**
     * 定义一个方法，传入边界，还需要一个临时存放的数组
     * 用左闭右开区间，用左右都是闭区间的话，会死循环，因为两个数组中间有个重合的元素
     */
    private void msort(int[] nums, int left, int right, int[] temp) {
        // 只有一个元素或者没有元素
        if (left >= right || right - left == 1) {
            return;
        }
        // 计算中间，从中间分开
        int mid = left + (right - left) / 2;

        // 分别对左右子数组排序
        msort(nums, left, mid, temp);
        msort(nums, mid, right, temp);

        // 合并两个子数组[left, mid], [mid, right]，用temp存放
        int i1 = left;
        int i2 = mid;
        int i = left;
        while (i1 < mid || i2 < right) {
            // 如果一个数组已经没元素了
            if (i1 >= mid) {
                temp[i] = nums[i2];
                i2++;
            } else if (i2 >= right){
                temp[i] = nums[i1];
                i1++;
            } else {
                if (nums[i1] <= nums[i2]) {
                    temp[i] = nums[i1];
                    i1++;
                } else {
                    temp[i] = nums[i2];
                    i2++;
                }
            }
            i++;
        }
        // 将temp中元素拷贝到原数组
        for (int j = left; j < right; j++) {
            nums[j] = temp[j];
        }

    }

    public static void main(String[] args) {
        MyMergeSort mergeSort = new MyMergeSort();
        int[] nums = {3, 2, 8, 7, 1};
        mergeSort.mergeSort(nums);
        System.out.println();
    }

}
