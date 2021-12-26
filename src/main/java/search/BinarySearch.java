package search;

/**
 * @author mengruo
 * 二分查找
 */
public class BinarySearch {
    public int search(int[] nums, int value){
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (value == nums[mid]) {
                return mid;
            } else if (value > nums[mid]) {
                // left需要变为mid+1，而不是mid，为mid可能造成死循环
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] a = {0, 3, 4};
        int result = binarySearch.search(a, 4);
        System.out.println("结果：" + result);
    }
}
