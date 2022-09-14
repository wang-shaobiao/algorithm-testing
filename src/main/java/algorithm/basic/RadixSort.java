package algorithm.basic;

import java.util.Arrays;

public class RadixSort {
    //不考虑负数
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        radixSort(arr, 0, arr.length - 1, getBits(arr));
    }
    /**
     * 主方法逻辑
     */
    public static void radixSort(int[] arr, int l, int r, int d) {
        //创建辅助数组，排序完成后通过help数组归到原数组中
        int[] help = new int[r - l + 1];

        //根据d值，也就是位深度，决定外层d次循环
        //从个位开始，d次循环后，即完成排序
        for (int i = 1; i <= d; i++) {
            //创建计数数组
            int[] count = new int[10];
            //进行原数组频次计数
            for (int j = l; j <= r; j++) {
                count[getDigit(arr[j], i)]++;
            }
            //count数组进行前缀累加
            for (int j = 1; j < 10; j++) {
                count[j] = count[j] + count[j - 1];
            }
            //此次排序放入help数组
            for (int j = r; j >= l; j--) {
                int e = --count[getDigit(arr[j], i)];
                help[e] = arr[j];
            }
            //help数组归入原数组arr中
            for (int j = 0; j < help.length; j++) {
                arr[l + j] = help[j];
            }
        }
    }
    /*
    工具类方法
    1. 获取十进制位数
    2. 获取对应位置的值
     */
    public static int getBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        //主要逻辑
        int count =0;
        while (max != 0) {
            count++;
            max /= 10;
        }
        return count;
    }

    public static int getDigit(int value, int d) {
        //int强制转换保证>=0
        //最终%10,以余数方式获取
        return (value/((int)Math.pow(10, d-1)) % 10);
    }
    public static void main(String[] args) {
        int[] a = new int[]{1, 222, 33, 26, 444, 1345, 111};
        radixSort(a);
        Arrays.stream(a).forEach(b -> System.out.println(b + ""));
    }
}
