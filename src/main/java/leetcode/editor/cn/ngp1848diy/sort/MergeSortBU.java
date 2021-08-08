package leetcode.editor.cn.ngp1848diy.sort;

import static java.lang.Integer.min;
import static leetcode.editor.cn.ngp1848diy.sort.InsertSort.insertionSortTimeGeekBang;
import static leetcode.editor.cn.ngp1848diy.sort.MergeSort.merge;

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
            for (int i = 0; i + sz < n; i += sz + sz) {
                //对arr[i...i+sz-1] 和arr[i+sz...i+2*sz-1] 进行归并
                //(i + sz) 保证 (i + sz - 1) 不越界
                //min(i + sz + sz - 1, n - 1) 保证 (i + sz + sz - 1) 不越界
                merge(arr, i, i + sz - 1, min(i + sz + sz - 1, n - 1));
            }
        }
    }

    //自底向上 的 归并排序, 代码量出奇的少
    //速度比自顶向下稍微慢一点,但是没有通过索引直接获取元素
    // 自底向上的归并排序, 可以用O(nlogn)时间对链表这样的数据结构, 进行排序
    static void mergeSortBUPlus(int[] arr, int n) {
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                int l = i;
                int mid = i + sz - 1;
                int r = min(i + sz + sz - 1, n - 1);
                if (r - l <= 7) {
                    insertionSortTimeGeekBang(arr, l, r);
                } else {
                    if (arr[mid] > arr[mid + 1]) {
                        //对arr[i...i+sz-1] 和arr[i+sz...i+2*sz-1] 进行归并
                        //(i + sz) 保证 (i + sz - 1) 不越界
                        //min(i + sz + sz - 1, n - 1) 保证 (i + sz + sz - 1) 不越界
                        merge(arr, l, mid, r);
                    }
                }
            }
        }
    }
}
