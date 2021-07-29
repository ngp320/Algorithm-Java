package leetcode.editor.cn.sort;

import static java.lang.Integer.min;
import static leetcode.editor.cn.sort.InsertSort.insertionSort_timeGeekBang;
import static leetcode.editor.cn.sort.MergeSort.merge;

/**
 * @ClassName: MergeSortD2U
 * @Description: MergeSort Buttom Up
 * @Version:
 * @Author: �ƺ�
 * @Date: 2021/7/29 9:42
 */
public class MergeSortBU {
    //�Ե����� �� �鲢����, �������������
    static void mergeSortBU(int[] arr, int n) {

        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz){
                //��arr[i...i+sz-1] ��arr[i+sz...i+2*sz-1] ���й鲢
                //(i + sz) ��֤ (i + sz - 1) ��Խ��
                //min(i + sz + sz - 1, n - 1) ��֤ (i + sz + sz - 1) ��Խ��
                merge(arr, i, i + sz - 1, min(i + sz + sz - 1, n - 1));
            }
        }
    }
    //�Ե����� �� �鲢����, �������������
    static void mergeSortBUPlus(int[] arr, int n) {

        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz){
                if (min(i + sz + sz - 1, n - 1) - (i) <= 7) {
                    insertionSort_timeGeekBang(arr, i, min(i + sz + sz - 1, n - 1));
                }else {
                    //��arr[i...i+sz-1] ��arr[i+sz...i+2*sz-1] ���й鲢
                    //(i + sz) ��֤ (i + sz - 1) ��Խ��
                    //min(i + sz + sz - 1, n - 1) ��֤ (i + sz + sz - 1) ��Խ��
                    merge(arr, i, i + sz - 1, min(i + sz + sz - 1, n - 1));
                }
            }
        }
    }
}
