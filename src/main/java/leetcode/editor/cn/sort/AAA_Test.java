package leetcode.editor.cn.sort;

import leetcode.editor.cn.utils.Timer;
import leetcode.editor.cn.utils.TimerUtil;

import java.util.Arrays;

import static leetcode.editor.cn.sort.InsertSort.insertionSort_timeGeekBang;
import static leetcode.editor.cn.sort.MergeSort.mergeSortRecursion;
import static leetcode.editor.cn.sort.MergeSort.mergeSortRecursionPlus;
import static leetcode.editor.cn.sort.MergeSortBU.mergeSortBU;
import static leetcode.editor.cn.sort.MergeSortBU.mergeSortBUPlus;
import static leetcode.editor.cn.sort.ShellSort.*;
import static leetcode.editor.cn.utils.SortTestHelper.*;

/**
 * @ClassName: Test
 * @Description:
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/7/27 17:29
 */
public class AAA_Test {
    //在 TimerUtil中, 添加一个 obj.t_isSorted(obj.arr)
    private static int N = 100000;
    private static int[] arrOrigin = generateRandomArray(N, 0, N);
    //int[] arrOrigin = generateNearlyOrderedArray(N, 10);


    @Timer
    void mergeSortTest() throws Exception {
        int[] arr = Arrays.copyOf(arrOrigin, N);
        mergeSortRecursion(arr, 0, arr.length - 1);
        if (!isSorted(arr)) {
            String methodName = Thread.currentThread() .getStackTrace()[1].getMethodName();
            throw new Exception(methodName+" sort Exception");
        }
    }

    @Timer
    void mergeSortPlusTest() throws Exception {
        int[] arr = Arrays.copyOf(arrOrigin, N);
        mergeSortRecursionPlus(arr, 0, arr.length - 1);
        if (!isSorted(arr)) {
            String methodName = Thread.currentThread() .getStackTrace()[1].getMethodName();
            throw new Exception(methodName+" sort Exception");
        }
    }

    @Timer
    void mergeSortBUTest() throws Exception {
        int[] arr = Arrays.copyOf(arrOrigin, N);
        mergeSortBU(arr, arr.length);
        if (!isSorted(arr)) {
            String methodName = Thread.currentThread() .getStackTrace()[1].getMethodName();
            throw new Exception(methodName+" sort Exception");
        }

    }

    @Timer
    void mergeSortBUPlusTest() throws Exception {
        int[] arr = Arrays.copyOf(arrOrigin, N);
        mergeSortBUPlus(arr, arr.length);
        if (!isSorted(arr)) {
            String methodName = Thread.currentThread() .getStackTrace()[1].getMethodName();
            throw new Exception(methodName+" sort Exception");
        }
    }

    @Timer
    void insertSortTest() throws Exception {
        int[] arr = Arrays.copyOf(arrOrigin, N);
        insertionSort_timeGeekBang(arr, 0, arr.length - 1);
        if (!isSorted(arr)) {
            String methodName = Thread.currentThread() .getStackTrace()[1].getMethodName();
            throw new Exception(methodName+" sort Exception");
        }
    }


    @Timer
    void shellSortTest() throws Exception {
        int[] arr = Arrays.copyOf(arrOrigin, N);
        shellSort(arr);
        if (!isSorted(arr)) {
            String methodName = Thread.currentThread() .getStackTrace()[1].getMethodName();
            throw new Exception(methodName+" sort Exception");
        }
    }

    @Timer
    void shellSort_3hAdd1Test() throws Exception {
        int[] arr = Arrays.copyOf(arrOrigin, N);
        shellSort_3hAdd1(arr);
        if (!isSorted(arr)) {
            String methodName = Thread.currentThread() .getStackTrace()[1].getMethodName();
            throw new Exception(methodName+" sort Exception");
        }
    }


    public static void main(String[] args) {
        System.out.println("数组长度为: "+N);
        //打印数组前十个
        System.out.print("数组前十个为: ");
        Arrays.stream(arrOrigin).limit(10).forEach(in -> System.out.print(in+" "));
        System.out.println();

        TimerUtil timerUtil = new TimerUtil();
        timerUtil.getTime();
    }

}
