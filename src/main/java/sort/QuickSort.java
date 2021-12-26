package sort;

import java.util.Arrays;

/**
 * @author Mengruo
 * 快速排序
 */
public class QuickSort {
    public void sort(int[] nums){
        if (nums.length == 1) {
            return;
        }
        quickSort(nums, 0, nums.length - 1);
    }
    public void quickSort(int[] nums, int low, int high){
        if(low >= high){
            return;
        }
        int initialLow = low;
        int initialHigh = high;

        int pivot = nums[low];
        while(low < high){
            while(low < high && nums[high] >= pivot){
                high--;
            }
            swap(nums, low, high);
            while(low < high && nums[low] < pivot){
                low++;
            }
            swap(nums, low, high);
        }

        quickSort(nums, initialLow, low-1);
        quickSort(nums, high+1, initialHigh);
    }

    private void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {5, 46, 2, 7, 34, 14, 6,78,11,22,35};
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

