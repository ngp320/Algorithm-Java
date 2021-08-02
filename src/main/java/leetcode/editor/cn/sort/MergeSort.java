package leetcode.editor.cn.sort;

import static leetcode.editor.cn.sort.InsertSort.insertionSortTimeGeekBang;

/**
 * @ClassName: MergeSort
 * @Description:
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/7/27 16:54
 */
public class MergeSort {
    //将arr[l... mid]和arr [mid+1...r]两部分进行归并
    static void merge(int[] arr, int l, int mid, int r) {

        //完成临时空间
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            //aux是从0开始的, arr从l开始l, 所以有个l距离的偏移量
            aux[i - l] = arr[i];
        }

        // --> arr[l... mid]和arr [mid+1...r] 开头
        int i = l;
        int j = mid + 1;
        // --> arr[l... mid]和arr [mid+1...r] 闭区间
        //aux里比较(因为元素不会改变), 往arr里覆盖
        for (int k = l; k <= r; k++) {
            //首先判断 i, j 越界的情况
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            }
            // 逻辑 谁小谁放前面
            else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else  {
                arr[k] = aux[j - l];
                j++;
            }
        }


    }


    // 自顶向下的 mergeSort是, merge范围依次是 N, N/2, N/4 ... 1
    //递归使用归并排序,对arr[l...r]的范围进行排序
    static void mergeSortRecursion(int[] arr, int l, int r) {
        // 首先对于一个递归函数来说, 我们需要首先处理的是, 递归到底的情况.
        if (l >= r) { // l >= r 适用于自底向上
            return;
        }
        int mid = (l + r) / 2;
        mergeSortRecursion(arr, l, mid);
        mergeSortRecursion(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    //递归使用归并排序,对arr[l...r]的范围进行排序
    static void mergeSortRecursionPlus(int[] arr, int l, int r) {
        // 当整个数组比较小的时候, 使用 插入排序提高性能
        // 1 一方面, 整个数组比较小的时候, 整个数组有序的概率比较大, 插入排序有优势
        // 2 另外一方面, 插入排序最差的是O(n^2), 归并排序最差是O(nlogn), 对于时间复杂度
        // 前面是有一个被忽略的系数的, 这个系数 插入排序 比 归并排序 小.
        if (r - l <= 7) {
            insertionSortTimeGeekBang(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;
        mergeSortRecursion(arr, l, mid);
        mergeSortRecursion(arr, mid + 1, r);
        // 因为子数组有序, 所以如果 左数组last<有数组first, 就不需要归并 (效率提高约 65%)
        // 如果有可能遇到近乎有序的数组, 则建议加上这一层判断
        //if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        //}
    }

}
