package leetcode.editor.cn.utils;

/**
 * @ClassName: printarr
 * @Description: TODO
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/7/28 16:31
 */
public class printArray {
    // 打印arr数组的所有内容
     static void printArray(Object[] arr) {

        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();

        return;
    }
}
