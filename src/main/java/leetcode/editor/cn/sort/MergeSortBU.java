package leetcode.editor.cn.sort;

import static java.lang.Integer.min;
import static leetcode.editor.cn.sort.InsertSort.insertionSort_timeGeekBang;
import static leetcode.editor.cn.sort.MergeSort.merge;

/**
 * @ClassName: MergeSortD2U
 * @Description: MergeSort Buttom Up
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/7/29 9:42
 */
public class MergeSortBU {
    //自底向上 的 归并排序, 代码量出奇的少
    static void mergeSortBU(int[] arr, int n) {

        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz){
                //对arr[i...i+sz-1] 和arr[i+sz...i+2*sz-1] 进行归并
                //(i + sz) 保证 (i + sz - 1) 不越界
                //min(i + sz + sz - 1, n - 1) 保证 (i + sz + sz - 1) 不越界
                merge(arr, i, i + sz - 1, min(i + sz + sz - 1, n - 1));
            }
        }
    }
    //自底向上 的 归并排序, 代码量出奇的少
    static void mergeSortBUPlus(int[] arr, int n) {

        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz){
                if (min(i + sz + sz - 1, n - 1) - (i) <= 7) {
                    insertionSort_timeGeekBang(arr, i, min(i + sz + sz - 1, n - 1));
                }else {
                    //对arr[i...i+sz-1] 和arr[i+sz...i+2*sz-1] 进行归并
                    //(i + sz) 保证 (i + sz - 1) 不越界
                    //min(i + sz + sz - 1, n - 1) 保证 (i + sz + sz - 1) 不越界
                    merge(arr, i, i + sz - 1, min(i + sz + sz - 1, n - 1));
                }
            }
        }
    }
}
