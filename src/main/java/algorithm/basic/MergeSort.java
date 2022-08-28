package algorithm.basic;

public class MergeSort {
    /**
     * 归并排序
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort02process(arr, 0, arr.length - 1);
    }

    public static void mergeSort02process(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        //中点
        int mid = l + ((r - l) >> 1);
        //中点切开，递归进行各自范围内的排序
        mergeSort02process(arr, l, mid);
        mergeSort02process(arr, mid + 1, r);
        //部分排序完成后，进行合并排序
        mergeSort03merge(arr, l, mid+1, r);

    }

    //归并排序核心步骤
    public static void mergeSort03merge(int[] arr, int l, int m, int r) {
        //辅助数组
        int[] help = new int[r - l + 1];
        //辅助指针（下标）
        //左
        int pl = l;
        //右
        int pr = m;
        //辅助数组指针
        int i = 0;
        //左右都未越界
        while (pl < m && pr <= r) {
            help[i++] = arr[pl] <= arr[pr] ? arr[pl++] : arr[pr++];
        }
        //左未越界，右越界
        while (pl < m) {
            help[i++] = arr[pl++];
        }
        //左越界，右未越界
        while (pr <= r) {
            help[i++] = arr[pr++];
        }
        //数组合并
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

    }
}
