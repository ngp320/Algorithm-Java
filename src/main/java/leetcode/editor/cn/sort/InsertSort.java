package leetcode.editor.cn.sort;

/**
 * @ClassName: insertSort
 * @Description: TODO
 * @Version:
 * @Author: �ƺ�
 * @Date: 2021/7/27 17:29
 */
public class InsertSort {
     static void insertionSort_timeGeekBang(int[] arr, int left, int right) {
        for (int i = left+1; i <= right ; ++i) {
            int value = arr[i];
            int j = i - 1;
            // ���Ҳ����λ��
            for (; j >= left; --j) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];  // �����ƶ�
                } else {
                    break;
                }
            }
            arr[j+1] = value; // ��������
        }
    }
}
