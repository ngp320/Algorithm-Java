package leetcode.editor.cn.utils;

/**
 * @ClassName: RandomArray
 * @Description: TODO
 * @Version:
 * @Author: �ƺ�
 * @Date: 2021/7/29 13:47
 */
public class RandomArray {
    RandomArray() {
    }
    // ������n��Ԫ�ص��������,ÿ��Ԫ�ص������ΧΪ[rangeL, rangeR]
    private static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =  (int)(Math.random() * (rangeR - rangeL + 1) + rangeL);
        }
        return arr;
    }

}
