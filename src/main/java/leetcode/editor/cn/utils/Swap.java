package leetcode.editor.cn.utils;

/**
 * @ClassName: Swap
 * @Description: TODO
 * @Version:
 * @Author: �ƺ�
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
