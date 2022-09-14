package algorithm.basic.appliction;

import algorithm.basic.HeapSort;
import utils.RandomArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class SortArrayDistancelessK {
    //k表示 移动距离不超过k,即 <= k
    public static void sortedArrDistanceLessK(int[] arr, int k) {
        //默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        //1.初次入堆
        int index = 0;
        for (; index <= Math.min(arr.length - 1, k); index++) {
            heap.add(arr[index]);
        }
        //2.k>arr.length,初次入堆之后进行二次入堆
        for (int i=0;i<arr.length;index++,i++ ) {
            arr[i] = heap.poll();
            if (index < arr.length) {
                heap.add(arr[index]);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 3, 5, 7, 2, 6, 8};
        sortedArrDistanceLessK(a, 9);
        Arrays.stream(a).forEach(b -> System.out.print(b + " "));
    }
}
