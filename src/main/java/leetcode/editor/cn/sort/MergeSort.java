package leetcode.editor.cn.sort;

import leetcode.editor.cn.utils.Timer;
import leetcode.editor.cn.utils.TimerUtil;

import static leetcode.editor.cn.sort.InsertSort.insertionSort_timeGeekBang;

/**
 * @ClassName: MergeSort
 * @Description: TODO
 * @Version:
 * @Author: �ƺ�
 * @Date: 2021/7/27 16:54
 */
public class MergeSort {
    //��arr[l... mid]��arr [mid+1...r]�����ֽ��й鲢
    static void merge(int[] arr, int l, int mid, int r) {

        //�����ʱ�ռ�
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            //aux�Ǵ�0��ʼ��, arr��l��ʼl, �����и�l�����ƫ����
            aux[i - l] = arr[i];
        }

        // --> arr[l... mid]��arr [mid+1...r] ��ͷ
        int i = l;
        int j = mid + 1;
        // --> arr[l... mid]��arr [mid+1...r] ������
        //aux��Ƚ�(��ΪԪ�ز���ı�), ��arr�︲��
        for (int k = l; k <= r; k++) {
            //�����ж� i, j Խ������
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            }
            // �߼� ˭С˭��ǰ��
            else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else  {
                arr[k] = aux[j - l];
                j++;
            }
        }


    }


    // �Զ����µ� mergeSort��, merge��Χ������ N, N/2, N/4 ... 1
    //�ݹ�ʹ�ù鲢����,��arr[l...r]�ķ�Χ��������
    static void mergeSortRecursion(int[] arr, int l, int r) {
        // ���ȶ���һ���ݹ麯����˵, ������Ҫ���ȴ������, �ݹ鵽�׵����.
        if (l >= r) { // l >= r �������Ե�����
            return;
        }
        int mid = (l + r) / 2;
        mergeSortRecursion(arr, l, mid);
        mergeSortRecursion(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    //�ݹ�ʹ�ù鲢����,��arr[l...r]�ķ�Χ��������
    static void mergeSortRecursionPlus(int[] arr, int l, int r) {
        // ���ȶ���һ���ݹ麯����˵, ������Ҫ���ȴ������, �ݹ鵽�׵����.
        if (l >= r) {
            return;
        }
        // ����������Ƚ�С��ʱ��, ʹ�� ���������������
        // 1 һ����, ��������Ƚ�С��ʱ��, ������������ĸ��ʱȽϴ�, ��������������
        // 2 ����һ����, ��������������O(n^2), �鲢���������O(nlogn), ����ʱ�临�Ӷ�
        // ǰ������һ�������Ե�ϵ����, ���ϵ�� �������� �� �鲢���� С.
        if (r - l <= 7) {
            insertionSort_timeGeekBang(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;
        mergeSortRecursion(arr, l, mid);
        mergeSortRecursion(arr, mid + 1, r);
        // ��Ϊ����������, ������� ������last<������first, �Ͳ���Ҫ�鲢 (Ч�����Լ 65%)
        // ����п��������������������, ���������һ���ж�
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }
    }

}
