package leetcode.editor.cn.ngp1848diy.utils;

/**
 * @ClassName: GenerateRandomNumInBounds
 * @Description:
 * @Version:
 * @Author: 唐浩
 * @Date: 2021/8/2 11:42
 */
public class GenerateRandomNumInBounds {
    public static int generateRandomNumInBounds(int lowBound, int highBound) {
        return (int) (lowBound +(highBound - lowBound )*Math.random());
    }
}
