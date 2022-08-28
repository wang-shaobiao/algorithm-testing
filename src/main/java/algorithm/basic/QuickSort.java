package algorithm.basic;

import utils.SwapUtils;
import static utils.SwapUtils.swap;

public class QuickSort {
    /**
     * 快排3.0，随机取值
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        quickSort02Process(arr,0,arr.length-1);
    }
    public static void quickSort02Process(int[] arr,int l,int r) {
        if (l < r) {
            //随机取划分值
            SwapUtils.swap(arr,l+(int)Math.random()*(r-l+1),r);
            int[] p = quickSort03Partition(arr, l, r);
            quickSort02Process(arr, l, p[0]);
            quickSort02Process(arr, p[1], r);
        }
    }
    //快排核心方法
    public static int[] quickSort03Partition(int[] arr, int l, int r) {
        //3指针
        //小于区域右边界指针
        int pl = l-1;
        //大于区域左边界指针,不计入划分值所在的最后位置
        int pr = r;
        //移动指针
        int p = l;
        //循环结束 移动指针>=大于区域右边界
        while(p<pr){
            if (arr[p] < arr[r]) {
                swap(arr, ++pl, p++);
            } else if (arr[p] > arr[r]) {
                swap(arr, --pr, p);
            } else {
                p++;
            }
        }
        swap(arr, pr++, r);
        return new int[]{pl,pr};
    }
}
