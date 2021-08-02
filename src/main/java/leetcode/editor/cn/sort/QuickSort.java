package leetcode.editor.cn.sort;

import static leetcode.editor.cn.sort.InsertSort.insertionSortTimeGeekBang;
import static leetcode.editor.cn.utils.SortTestHelper.printArray;

/**
 * @ClassName: QuickSort
 * @Description:
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/8/1 22:16
 */
public class QuickSort {
    public static void quickSortPlus(int[] arr, int l, int r) {
        //woc 快排居然提升60%, 归并才
        if (r - l <= 7) {
            insertionSortTimeGeekBang(arr, l, r);
        }
        //printArray(arr);
        // partition 分区 分隔物
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);

    }
    public static void quickSort(int[] arr, int l, int r) {
        //输入有误的情况
        if (l >= r) {
            return;
        }
        //printArray(arr);
        // partition 分区 分隔物
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);

    }

    private static int partition(int[] arr, int l, int r) {
        int p = arr[l];
        int j = l;
        // arr[l+1...j] < V ; arr[j+1...i) > V
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < p) {
                // 1 核心逻辑 如图 https://cdn.nlark.com/yuque/0/2021/png/332138/1627551126230-6a1173cb-0480-437e-a4c2-010a55d02086.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_33%2Ctext_eXVxdWUuY29tL19uZ3AvYmxvZw%3D%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
                // 2 通过把int p = arr[l] 设为分割数, i∈[l+1,r] , i++ , 如果arr[i]<val , 则 swap(arr[j + 1], arr[i]);
                // 3 遍历一遍, 最后交换 arr[l]和arr[j], 即可把所有小于 arr[l]的元素, 都放到 j最后坐标以 左.
                // 4 最后, 通过自顶向下的, 以p为 中间值, 切割开 [l...p-1] [p+1...r] 多次循环, 快速排序即完成. 全局最优, 局部不是最优
                swap(arr, j + 1, i);
                j++;
            }
        }
        //最后把 arr[l] 与 最后一个小于arr[l]的元素 交换, 快速排序完成
        swap(arr, l, j);
        // 返回的是 中间值 在数组中的位置, 而不是 value (讯飞
        return j;
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
