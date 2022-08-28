import algorithm.basic.QuickSort;
import utils.RandomArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static algorithm.basic.appliction.MergeSortSmallSum.mergeSortSmallSum;

public class Test01 {
    public static void main(String[] args) {
        ArrayList<int[]> test = RandomArrayUtils.getRandomArrayGroup(2000,1,10,5);
        Iterator<int[]> iterator = test.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            int[] arr = iterator.next();
            System.out.println("第" + i + "组------------------------------");
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
            System.out.println();
            //**************************
//            selectSort(arr);
//            bubbleSort(arr);
//            insertSort(arr);
//            mergeSort(arr);
            QuickSort.quickSort(arr);
//            System.out.println(mergeSortSmallSum(arr));
            //*************************
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
            System.out.println();
            i++;
        }
    }
}
