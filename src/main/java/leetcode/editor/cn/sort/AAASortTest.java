package leetcode.editor.cn.sort;

import leetcode.editor.cn.exception.ngpException;
import leetcode.editor.cn.utils.ListNode;
import leetcode.editor.cn.reflect.Timer;
import leetcode.editor.cn.reflect.TimerUtil;

import java.util.Arrays;

import static leetcode.editor.cn.sort.InsertSort.insertionSortTimeGeekBang;
import static leetcode.editor.cn.sort.MergeSort.mergeSortRecursion;
import static leetcode.editor.cn.sort.MergeSort.mergeSortRecursionPlus;
import static leetcode.editor.cn.sort.MergeSortBU.mergeSortBU;
import static leetcode.editor.cn.sort.MergeSortBU.mergeSortBUPlus;
import static leetcode.editor.cn.sort.MergeSortBULinkList.mergeSortBULinkList;
import static leetcode.editor.cn.sort.QuickSort.quickSort;
import static leetcode.editor.cn.sort.QuickSort.quickSortPlus;
import static leetcode.editor.cn.sort.ShellSort.shellSort;
import static leetcode.editor.cn.sort.ShellSort.shellSort3hAdd1;
import static leetcode.editor.cn.utils.SortTestHelper.*;

/**
 * @ClassName: AAASortTest
 * @Description:
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/7/27 17:29
 */
public class AAASortTest {
    public static final String EXCEPTION_END_STR = " sort fail";
    //在 TimerUtil中, 添加一个 obj.t_isSorted(obj.arr)
    private static final int N = 50000;
    private static final int[] ARRAY_ORIGIN = generateRandomArray(N, 0, N);
    //private static int[] arrOrigin = generateNearlyOrderedArray(N, 0);


    @Timer(order=301)
    void mergeSortRecursionTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        mergeSortRecursion(arr, 0, arr.length - 1);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }

    @Timer(order=302)
    void mergeSortPlusTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        mergeSortRecursionPlus(arr, 0, arr.length - 1);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }

    @Timer(order=303)
    void mergeSortBUTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        mergeSortBU(arr, arr.length);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }

    }

    @Timer(order=304)
    void mergeSortBUPlusTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        mergeSortBUPlus(arr, arr.length);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }

    @Timer(order=305)
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


    @Timer(order=101)
    void insertSortTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        insertionSortTimeGeekBang(arr, 0, arr.length - 1);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }


    @Timer(order=102)
    void shellSortTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        shellSort(arr);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }

    @Timer(order=103)
    void shellSort3hAdd1Test() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        shellSort3hAdd1(arr);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }


    @Timer(order=209)
    void quickSortTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        quickSort(arr, 0, arr.length-1);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }


    @Timer(order=210)
    void quickSortPlusTest() throws ngpException {
        int[] arr = Arrays.copyOf(ARRAY_ORIGIN, N);
        quickSortPlus(arr, 0, arr.length-1);
        if (!isArraySorted(arr)) {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            printArray(arr);
            throw new ngpException(methodName + EXCEPTION_END_STR);
        }
    }



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
