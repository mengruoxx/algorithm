package sort;

import java.util.Arrays;

/**
 * @author Mengruo
 * 快速排序
 */
public class QuickSort2 {
    public void sort(int[] nums){

    }

    /**
     *
     * @param nums
     * @param left 左闭
     * @param right 右开
     */
    public void qsort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int iLeft = left;
        int iRight = right;
        int pivot = nums[left];
        // 把数组处理成三部分
        while (left < right) {
            while (nums[right] >= pivot) {
                right--;
            }
            // 交换
            swap(nums, left, right);
            // 移动左指针
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            swap(nums, left, right);
        }

        // 递归处理左序列
        qsort(nums, iLeft, left - 1);
        // 递归处理右序列
        qsort(nums, right+ 1, iRight);
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        QuickSort2 quickSort = new QuickSort2();
        int[] nums = {5, 46, 2, 7, 34, 14, 6,78,11,22,35};
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

