package leetcode.editor.cn.utils;

/**
 * @ClassName: printarr
 * @Description: TODO
 * @Version:
 * @Author: �ƺ�
 * @Date: 2021/7/28 16:31
 */
public class printArray {
    // ��ӡarr�������������
     static void printArray(Object[] arr) {

        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();

        return;
    }
}
