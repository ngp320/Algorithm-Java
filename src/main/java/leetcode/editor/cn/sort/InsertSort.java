package leetcode.editor.cn.sort;

/**
 * @ClassName: insertSort
 * @Description:
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/7/27 17:29
 */
public class InsertSort {
     static void insertionSortTimeGeekBang(int[] arr, int l, int r) {
         if (l >= r) {
             return;
         }
        for (int i = l+1; i <= r ; ++i) {
            int value = arr[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= l; --j) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];  // 数据移动
                } else {
                    break;
                }
            }
            arr[j+1] = value; // 插入数据
        }
    }
}
