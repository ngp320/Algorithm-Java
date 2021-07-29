package leetcode.editor.cn.utils;

import java.lang.reflect.Method;

/**
 * @ClassName: asfdasd123
 * @Description: TODO
 * @Version:
 * @Author: �ƺ�
 * @Date: 2021/7/28 16:11
 */
public class SortTestHelper {

    // SortTestHelper����������κ�ʵ��
    private SortTestHelper(){}

    // ������n��Ԫ�ص��������,ÿ��Ԫ�ص������ΧΪ[rangeL, rangeR]
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert rangeL <= rangeR;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] =  (int)(Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        assert !isSorted(arr);
        return arr;
    }

    // ����һ���������������
    // ��������һ������[0...n-1]����ȫ��������, ֮���������swapTimes������
    // swapTimes���������������̶�:
    // swapTimes == 0 ʱ, ������ȫ����
    // swapTimes Խ��, ����Խ����������
    public static int[] generateNearlyOrderedArray(int n, int swapTimes){

        int[] arr = new int[n];
        for( int i = 0 ; i < n ; i ++ ) {
            arr[i] = i;
        }

        for( int i = 0 ; i < swapTimes ; i ++ ){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    // ��ӡarr�������������
    public static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();

        return;
    }
    // �ж�arr�����Ƿ�����
    public static boolean isSorted(int[] arr){

        for( int i = 0 ; i < arr.length - 1 ; i ++ ) {
            if( arr[i] > arr[i+1] ) {
                return false;
            }
        }
        return true;
    }

}
