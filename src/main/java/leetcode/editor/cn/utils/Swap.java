package leetcode.editor.cn.utils;

/**
 * @ClassName: Swap
 * @Description:
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/7/27 17:33
 */
public class Swap {
    public void swap(int x, int y) {
        if (x != y) {
            x ^=  y;
            y ^=  x;
            x ^=  y;
        }
    }

}
