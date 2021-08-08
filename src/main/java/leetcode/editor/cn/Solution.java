package leetcode.editor.cn;

/**
 * @ClassName: temp
 * @Description:
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/7/19 11:31
 */
public class Solution {
    private static int count = 0;
    public static void mergeSortRecursionSolution(int[] arr, int l, int r) {
        //printArray(arr);
        if (l - r >= 0) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSortRecursionSolution(arr, l, mid);
        mergeSortRecursionSolution(arr, mid + 1, r);

        merge(arr, l, mid, r);
        System.out.println(mid+" "+count);
    }

    // 2021-8-4 00:46:39 加深了对mergeSort的merge部分的理解
    // 写出正确的 mergeSort之后, 再添加count++
    private static void merge(int[] arr, int l, int mid, int r) {
        //拷贝一份数组
        int[] aux = new int[r - l + 1];
        for (int i = 0; i < r - l + 1; i++) {
            aux[i] = arr[i + l];
        }

        int i = l;
        int j = mid +1;
        for (int k = l; k <= r; k++) {
            //然后 在循环开始处 判断退出条件
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            }
            //小于等于 mergesort就有了稳定性 (相同元素相对位置不变)
            else if (aux[i - l] <= aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                //计算逆序度
                //若 j∈[mid+1...r] 部分的元素, 在i<=mid的前提下, 被放到了 arr[k]
                //则代表着, 这个元素, 和 当前[i...mid] 所有元素构成了逆序对
                arr[k] = aux[j - l];
                j++;
                count += mid - i +1;
            }


        }

    }

}

