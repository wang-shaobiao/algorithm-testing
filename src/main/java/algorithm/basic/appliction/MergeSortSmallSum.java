package algorithm.basic.appliction;

public class MergeSortSmallSum {
    /**
     * 归并排序-求小和
     */
    public static int  mergeSortSmallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSortSmallSum02process(arr, 0, arr.length - 1);
    }

    public static int mergeSortSmallSum02process(int[] arr, int l, int r) {
        if (l >= r) {
            return 0 ;
        }
        //中点
        int mid = l + ((r - l) >> 1);
        return mergeSortSmallSum02process(arr, l, mid)
                + mergeSortSmallSum02process(arr, mid + 1, r)
                + mergeSortSmallSum03merge(arr, l, mid + 1, r);
    }

    //归并排序核心步骤
    public static int mergeSortSmallSum03merge(int[] arr, int l, int m, int r) {
        //小和值
        int s = 0;
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
            s += arr[pl] <arr[pr]? arr[pl]*(r-pr+1):0;
            help[i++] = arr[pl] < arr[pr] ? arr[pl++] : arr[pr++];
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
        return s;
    }
}
