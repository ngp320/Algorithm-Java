package leetcode.editor.cn.sort;

import leetcode.editor.cn.utils.Timer;
import leetcode.editor.cn.utils.TimerUtil;

import java.time.LocalDateTime;

import static leetcode.editor.cn.utils.Utils.*;

/**
 * @ClassName: ShellSort
 * @Description: 最简单序列的 shell sort , 之后 还有 3*h+1
 * @Author: 唐浩
 * @Date: 2021/7/26 16:55
 */
public class ShellSort {
    @Timer
    private static void shellSort() {
        int[] arr = generateRandomArray(1000);
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
        printArray(arr);
    }

    @Timer
    private static void shellSort_3gap1() {
        int[] arr = generateRandomArray(1000);
        int length = arr.length;
        int temp;
        int gap = 1;
        while (gap < length / 3) {
            gap = gap * 3 + 1;
        }
        for (; gap > 0; gap /= 3) {
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
        printArray(arr);
    }

    public static void shellSort_train_01() {
        int[] arr = generateRandomArray(1000);
        int length = arr.length;
        int temp ;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            // 以下部分为插入排序
            for (int i = gap; i < length; i++) {
                temp = arr[i];
                int j = i-gap;
                // arr[j] < temp 重点的 < 或者 > 决定着排序顺序
                for (; j >= 0 && arr[j] > temp; j-=gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
        }
        printArray(arr);
    }





    @Timer
    public static void shellSort_train_20210727() {
        int[] arr = generateRandomArray(1000);
        printArray(arr);
        int length = arr.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                int temp = arr[i];
                int j = i -gap;
                for (; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
        }
        //567
        printArray(arr);
    }














    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        TimerUtil timerUtil = new TimerUtil();
        timerUtil.getTime();
        //shellSort_train_20210727();
    }


}
