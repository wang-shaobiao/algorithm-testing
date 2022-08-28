package algorithm.basic;

import static utils.SwapUtils.swap;

public class InsertionSort {
    //插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

}
