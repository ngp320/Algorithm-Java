package leetcode.editor.cn.ngp1848diy.utils;

import java.util.stream.IntStream;

/**
 * @ClassName: sfa
 * @Description:
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/7/28 16:29
 */
public class isSorted {
    public static boolean isSorted(int[] array) {
        return IntStream.range(0, array.length - 1).noneMatch(i -> array[i] > array[i + 1]);
    }
}
