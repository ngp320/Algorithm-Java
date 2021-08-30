package leetcode.editor.cn.ngp1848diy.sort;


/**
 * @ClassName: ShellSort
 * @Description: 最简单序列的 shell sort , 之后 还有 3*h+1
 * 很多优化虽然写起来很复杂, 但背后的思想是很有意思的.
 * @Author: 唐浩
 * @Date: 2021/7/26 16:55
 */
public class ShellSort {
    // 优化:  特殊序列 提高性能
    // 好像比普通 shellsort, 是能省 1/3 的时间
    static void shellSort3hAdd1(int[] arr) {
        int length = arr.length;
        int temp;
        int sz = 1;
        while (sz < length / 3) {
            sz = sz * 3 + 1;
        }
        while (sz > 0) {
            // 以下部分为插入排序
            for (int i = sz; i < length; i++) {
                //寻找元素arr[i]合适的插入位置
                temp = arr[i];
                int j = i - sz; // j保存元素e应该插入的位置
                for (; j >= 0 && arr[j] > temp; j -= sz) {
                    arr[j + sz] = arr[j];
                }
                arr[j + sz] = temp;
            }
            sz /= 3;
        }

    }


       static void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int sz = length / 2; sz > 0; sz /= 2) {
            // 以下部分为插入排序
            for (int i = sz; i < length; i++) {
                //寻找元素arr[i]合适的插入位置
                temp = arr[i];
                int j = i - sz; // j保存元素e应该插入的位置
                for (; j >= 0 && arr[j] > temp; j -= sz) {
                    arr[j + sz] = arr[j];
                }
                arr[j + sz] = temp;
            }

        }

    }


}
