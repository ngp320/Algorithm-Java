package leetcode.editor.cn.utils;

import java.util.stream.IntStream;

/**
 * @ClassName: sfa
 * @Description: TODO
 * @Version:
 * @Author: ÌÆºÆ
 * @Date: 2021/7/28 16:29
 */
public class isSorted {
    public static boolean isSorted(int[] array) {
        return IntStream.range(0, array.length - 1).noneMatch(i -> array[i] > array[i + 1]);
    }
}
