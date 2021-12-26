package sort;

import java.util.Arrays;

public class InsertSort {
    public static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int target = a[i];
            int j = i - 1 ;
            while (j >= 0 && a[j] > target) {
                a[j + 1] = a[j];
                j --;
            }
            a[j + 1] = target;
        }
    }

    public static void main(String[] args) {
        int[] a = {3,7,4,10,2,6};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
