package leetcode.editor.cn.sort;


/**
 * @ClassName: ShellSort
 * @Description: 最简单序列的 shell sort , 之后 还有 3*h+1
 * 很多优化虽然写起来很复杂, 但背后的思想是很有意思的.
 * @Author: 唐浩
 * @Date: 2021/7/26 16:55
 */
public class ShellSort {

       static void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            // 以下部分为插入排序
            for (int i = gap; i < length; i++) {
                //寻找元素arr[i]合适的插入位置
                temp = arr[i];
                int j = i - gap; // j保存元素e应该插入的位置
                for (; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }

        }

    }

     //好像比普通 shellsort, 是能省 1/3 的时间
     static void shellSort_3hAdd1(int[] arr) {
        int length = arr.length;
        int temp;
        int gap = 1;
        while (gap < length / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            // 以下部分为插入排序
            for (int i = gap; i < length; i++) {
                //寻找元素arr[i]合适的插入位置
                temp = arr[i];
                int j = i - gap; // j保存元素e应该插入的位置
                for (; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
             gap /= 3;
        }

    }


}
