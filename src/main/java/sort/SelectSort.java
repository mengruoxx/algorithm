package sort;

import java.util.Arrays;

public class SelectSort {
    public static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            // 右子序列的最小值的索引
            int minIndex = i;
            for (int j = i; j < a.length; j++) {
                // 找出minIndex
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 与i所在位置交换，至此第i位排序好了
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {3,7,4,10,2,6};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
