package leetcode.editor.cn.sort;


/**
 * @ClassName: ShellSort
 * @Description: ������е� shell sort , ֮�� ���� 3*h+1
 * �ܶ��Ż���Ȼд�����ܸ���, �������˼���Ǻ�����˼��.
 * @Author: �ƺ�
 * @Date: 2021/7/26 16:55
 */
public class ShellSort {

       static void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            // ���²���Ϊ��������
            for (int i = gap; i < length; i++) {
                //Ѱ��Ԫ��arr[i]���ʵĲ���λ��
                temp = arr[i];
                int j = i - gap; // j����Ԫ��eӦ�ò����λ��
                for (; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }

        }

    }

     //�������ͨ shellsort, ����ʡ 1/3 ��ʱ��
     static void shellSort_3hAdd1(int[] arr) {
        int length = arr.length;
        int temp;
        int gap = 1;
        while (gap < length / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            // ���²���Ϊ��������
            for (int i = gap; i < length; i++) {
                //Ѱ��Ԫ��arr[i]���ʵĲ���λ��
                temp = arr[i];
                int j = i - gap; // j����Ԫ��eӦ�ò����λ��
                for (; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
             gap /= 3;
        }

    }


}
