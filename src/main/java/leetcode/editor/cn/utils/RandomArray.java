package leetcode.editor.cn.utils;

/**
 * @ClassName: RandomArray
 * @Description: TODO
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/7/29 13:47
 */
public class RandomArray {
    RandomArray() {
    }
    // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
    private static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =  (int)(Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

}
