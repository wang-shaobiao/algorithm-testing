package algorithm.basic;

import utils.SwapUtils;

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int heapSize = arr.length;
        //1.建堆
        //1.1 heapInsert --o(nlogn)
        //1.2 heapify --收敛为o(n)
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, heapSize);
        }
        //2.堆排序 --O(n)
        SwapUtils.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);//o(logN）
            SwapUtils.swap(arr, 0, --heapSize);//o(1)
        }
    }
    public static void heapify(int[] arr, int index, int heapSize) {

        /**
         *考虑不需要heapify的条件
         * 1.没有子节点
         * 2.当前节点最大
         */
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            SwapUtils.swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
    //向上移动
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            SwapUtils.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
}
