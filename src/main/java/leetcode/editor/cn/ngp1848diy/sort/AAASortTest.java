package leetcode.editor.cn.ngp1848diy.sort;

import leetcode.editor.cn.ngp1848diy.exception.ngpException;
import leetcode.editor.cn.ngp1848diy.utils.ListNode;
import leetcode.editor.cn.ngp1848diy.reflect.Timer;
import leetcode.editor.cn.ngp1848diy.reflect.TimerUtil;

import java.util.Arrays;

import static leetcode.editor.cn.ngp1848diy.sort.InsertSort.insertionSortTimeGeekBang;
import static leetcode.editor.cn.ngp1848diy.sort.MergeSort.mergeSortRecursion;
import static leetcode.editor.cn.ngp1848diy.sort.MergeSort.mergeSortRecursionPlus;
import static leetcode.editor.cn.ngp1848diy.sort.MergeSortBU.mergeSortBU;
import static leetcode.editor.cn.ngp1848diy.sort.MergeSortBU.mergeSortBUPlus;
import static leetcode.editor.cn.ngp1848diy.sort.MergeSortBULinkList.mergeSortBULinkList;
import static leetcode.editor.cn.ngp1848diy.sort.QuickSort.*;
import static leetcode.editor.cn.ngp1848diy.sort.ShellSort.shellSort;
import static leetcode.editor.cn.ngp1848diy.sort.ShellSort.shellSort3hAdd1;
import static leetcode.editor.cn.ngp1848diy.utils.SortTestHelper.*;

/**
 * @ClassName: AAASortTest
 * @Description:
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/7/27 17:29
 */
public class AAASortTest {


    @Timer(order = 301)
    void mergeSortRecursionTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        mergeSortRecursion(arr, 0, arr.length - 1);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }

    @Timer(order = 302)
    void mergeSortPlusTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        mergeSortRecursionPlus(arr, 0, arr.length - 1);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }

    @Timer(order = 303)
    void mergeSortBUTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        mergeSortBU(arr, arr.length);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }

    }

    @Timer(order = 304)
    void mergeSortBUPlusTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        mergeSortBUPlus(arr, arr.length);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }

    @Timer(order = 305)
    void mergeSortBULinkListTest() throws ngpException {
        ListNode head = copyArrays2LinkList(ARRAY_ORIGIN);
        //原来的head节点, 会被merge到任一节点
        head = mergeSortBULinkList(head);
        if (!isLinkListSorted(head)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printLinkList(head);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }


    @Timer(order = 101)
    void insertSortTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        insertionSortTimeGeekBang(arr, 0, arr.length - 1);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }


    @Timer(order = 102)
    void shellSortTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        shellSort(arr);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }

    @Timer(order = 103)
    void shellSort3hAdd1Test() throws ngpException {

        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        shellSort3hAdd1(arr);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }

    ////递归实现, 容易Stackoverflow, 尤其是退化到O(n^2)的情况
    ////近乎有序的数组, 快排实在过于容易 stackoverflow, 故注释普通快排
    ////-Xmx3550m -Xms3550m -Xss3500m 可以暂时解决 stackoverflow 问题
    //@Timer(order = 209)
    //void quickSortTest() throws ngpException {
    //    int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
    //    quickSort(arr, 0, arr.length - 1);
    //    if (!isArraySorted(arr)) {
    //        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    //        printArray(arr);
    //        throw new ngpException(methodName + EXCEPTION_END_STR);
    //    }
    //}


    @Timer(order = 210)
    void quickSortPlusTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        quickSortPlus(arr, 0, arr.length - 1);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }

    @Timer(order = 211)
    void quickSortPlusAdaptToOrderedArrayTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        quickSortPlusPlus(arr, 0, arr.length - 1);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }

    @Timer(order = 212)
    void quickSort2WaysTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        quickSort2Ways(arr, 0, arr.length - 1);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }

    @Timer(order = 213)
    void quickSort3WaysTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        quickSort3Ways(arr, 0, arr.length - 1);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }



    private static int[] generateRepeatArray(int n, int l, int r) {
        return generateRandomArray(n, l, r);
    }

    public static int[] generateNearlyOrderedArrayReverse(int N, int swapTimes) {
        int[] originArray = generateNearlyOrderedArray(N, 0);
        int[] reverseArray = new int[originArray.length];
        for (int i = 0; i < originArray.length; i++) {
            reverseArray[i] = originArray[originArray.length - i - 1];
        }
        return reverseArray;
    }

    private static final String EXCEPTION_END_STR = " sort fail";
    //private static final int N = 10;                           //可以用于调试
    private static final int N = 65536;
    private static final int[] ARRAY_ORIGIN = generateRepeatArray(N, 0, 5); //大量重复元素
    //private static final int[] ARRAY_ORIGIN = generateRandomArray(N, 0, N);
    //private static int[] ARRAY_ORIGIN = generateNearlyOrderedArrayReverse(N, 1);
    //private static int[] ARRAY_ORIGIN = generateNearlyOrderedArray(N, 1);


    public static void main(String[] args) {

        System.out.println("数组长度为: " + N);
        //打印数组前十个
        System.out.print("数组前十个为: ");
        Arrays.stream(ARRAY_ORIGIN).limit(10).forEach(in -> System.out.print(in + " "));
        System.out.println();

        //每个函数打个 @Timer(order=1) 即可计时, 但是会多算 复制元素 的时间 O(n)
        TimerUtil timerUtil = new TimerUtil();
        timerUtil.getTime();
    }


}
