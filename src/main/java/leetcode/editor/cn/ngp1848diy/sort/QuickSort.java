package leetcode.editor.cn.ngp1848diy.sort;

import static leetcode.editor.cn.ngp1848diy.sort.InsertSort.insertionSortTimeGeekBang;
import static leetcode.editor.cn.ngp1848diy.utils.GenerateRandomNumInBounds.generateRandomNumInBounds;

/**
 * @ClassName: QuickSort
 * @Description: 笔记网址 https://www.yuque.com/_ngp/blog/yvok04/
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/8/1 22:16
 */
public class QuickSort {
    // 快排 也是 分治, 但是分出来的子数组可能是一大一小的。
    // 快速排序最差情况, 退化为O(n^2)
    //递归实现, 容易Stackoverflow, 尤其是退化到O(n^2)的情况
    public static void quickSortPlus(int[] arr, int l, int r) {
        //woc 快排居然提升60%, 归并排序才提升15%(大多数情况)~50%
        // 乱序数组, 快排已经比归并快约30%, 但是对 近乎有序的数组, 相对于归并排序, 5w个数组, 慢2个数量级
        // 插入排序, 处理 小数组
        if (r - l <= 7) {
            insertionSortTimeGeekBang(arr, l, r);
            return;
        }
        // partition 分区 分隔物
        int p = partition(arr, l, r);
        quickSortPlus(arr, l, p - 1);
        quickSortPlus(arr, p + 1, r);

    }

    //递归实现, 容易Stackoverflow, 尤其是退化到O(n^2)的情况
    public static void quickSort(int[] arr, int l, int r) {
        //输入有误的情况
        if (l - r >= 0) {
            return;
        }
        // partition 分区 分隔物
        //-Xms初始的Heap的大小。 -Xmx最大Heap的大小。
        //Vm Option 临时配置 -Xmx3550m -Xms3550m -Xss3500m 可以暂时解决
        //近乎有序的数组过大会 stackoverflow, 因为递归, 每次保存栈信息在64为机器8byte, 而近乎有序, 会递归N次
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }


    private static int partition(int[] arr, int l, int r) {
        int val = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < val) {
                // 1 核心逻辑 如图 https://cdn.nlark.com/yuque/0/2021/png/332138/1627551126230-6a1173cb-0480-437e-a4c2-010a55d02086.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_33%2Ctext_eXVxdWUuY29tL19uZ3AvYmxvZw%3D%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10
                // 2 通过把int p = arr[l] 设为分割数, i∈[l+1,r] , i++ , 如果arr[i]<val , 则 swap(arr[j + 1], arr[i]);
                // 3 遍历一遍, 最后交换 arr[l]和arr[j], 即可把所有小于 arr[l]的元素, 都放到 j最后坐标以 左.
                // 4 最后, 通过自顶向下的, 以 val 为 标定元素, 切割开 [l...p-1] [p+1...r] 多次循环, 快速排序即完成. 全局最优, 局部不是最优
                swap(arr, j + 1, i);
                j++;
            }
        }
        //最后把 arr[l] 与 最后一个小于arr[l]的元素 交换, 快速排序完成
        swap(arr, l, j);
        // 返回的是 中间值 在数组中的位置, 而不是 value (讯飞
        return j;
    }

    // O(NlogN) 证明比较复杂, 暂不考虑
    // 随机选取标定值, 防止快排遇到近乎有序的数组时退化到 O(n^2)
    public static void quickSortPlusPlus(int[] arr, int l, int r) {
        if (r - l <= 7) {
            insertionSortTimeGeekBang(arr, l, r);
            return;
        }

        // partition 分区 分隔物
        int p = partitionPlus(arr, l, r);

        quickSortPlusPlus(arr, l, p - 1);
        quickSortPlusPlus(arr, p + 1, r);

    }


    private static int partitionPlus(int[] arr, int l, int r) {
        //随机选一个标定元素, 与最左边的元素交换, 即可完成 随机标定的 快排
        int randomIndexInBound = generateRandomNumInBounds(l, r);
        swap(arr, randomIndexInBound, l);
        int val = arr[l];
        int j = l;
        // arr[l+1...j] < V ; arr[j+1...r) > V
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < val) {
                swap(arr, j + 1, i);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    // AdaptTo RepeatArray
    // 双路快排, 利用从两边开始快排, 平均把重复元素放到数组两头.
    // 解决, 分治时 由于有大量重复元素, 分出的两部分数组, 大小差距非常大, 退化到 O(n^2)
    public static void quickSort2Ways(int[] arr, int l, int r) {
        if (r - l <= 7) {
            insertionSortTimeGeekBang(arr, l, r);
            return;
        }

        // partition 分区 分隔物
        // arr[l+1...i) <= V; arr(j...r] >= V
        int p = partition2Ways(arr, l, r);

        quickSort2Ways(arr, l, p - 1);
        quickSort2Ways(arr, p + 1, r);

    }

    private static int partition2Ways(int[] arr, int l, int r) {
        int randomIndexInBound = generateRandomNumInBounds(l, r);
        swap(arr, randomIndexInBound, l);
        int val = arr[l];
        int i = l + 1;
        int j = r;
        // arr[l+1...i) <= V; arr(j...r] >= V
        while (true) {
            while (i <= r && arr[i] < val) {
                i++;
            }
            while (j >= l + 1 && arr[j] > val) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        // i 停在了, 从前往后看, i>j之后, 第一个大于等于val的位置
        // j 停在了, 从后往前看, i>j之后, 第一个小于等于val的位置
        // 结束条件  if (i > j), 若i==j还会继续, 则i会到达 arr(j...r] >= V, j会到达arr[l+1...i) <= V
        // 因为 l的位置只能放 值<=val 的元素, 不然会影响下一递归, 故和 j交换
        swap(arr, l, j);
        return j;
    }

    // More AdaptTo RepeatArray
    //三路快速排序处理arr[l...r]
    //将arr[l...r]分为<V ; ==V ; >V三部分
    //之后递归对<V ; >V两部分继续进行三路快速排序
    // 把重复元素, 放到中间, 相对于双路快排效率更高一点,
    public static void quickSort3Ways(int[] arr, int l, int r) {
        if (r - l <= 7) {
            insertionSortTimeGeekBang(arr, l, r);
            return;
        }

        int randomIndexInBound = generateRandomNumInBounds(l, r);
        swap(arr, randomIndexInBound, l);
        int val = arr[l];

        int lt = l; // arr[l+1...lt] < V   //即<V部分, 初始化为空
        int gt = r + 1; // arr[gt...r] > M   //即>V部分, 初始化为空

        // 之所以是开区间, 是因为i在循环里是正在考察的元素
        // lt+1 = l+1 = i = l+1  //       即==V部分, 初始化为空
        int i = l + 1;         // arr[lt+1...i)== M

        // 过程如图  见https://www.yuque.com/_ngp/blog/yvok04/
        while (i < gt) {
            if (arr[i] < val) {
                swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i] > val) {
                // 此处 i 不需要动, 因为经过 swap处理, i依然指向了一个未被处理的元素.
                swap(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        // 单次处理结束后, 如图  见https://www.yuque.com/_ngp/blog/yvok04/
        quickSort2Ways(arr, l, lt - 1);
        quickSort2Ways(arr, gt, r);
    }


    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
