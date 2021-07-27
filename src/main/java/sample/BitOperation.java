package sample;

import java.lang.reflect.Field;
import java.util.Collections;

/**
 * @ClassName: BitOperation
 * @Author: 唐浩
 * @Date: 2021/7/23 11:15
 */
public class BitOperation {


    public static void main(String[] args) {
        int z = -5;
        int a = 5 >> 3;
        int b = -5 >> 3;
        int c = -5 >>> 3;
        String bi_z = Integer.toBinaryString(z);
        String bi_a = Integer.toBinaryString(a);
        String bi_b = Integer.toBinaryString(b);
        String bi_c = Integer.toBinaryString(c);

        System.out.println(z);
        System.out.println(a);//结果是0
        System.out.println(b);//结果是-1
        System.out.println(c);//结果是536870911
        System.out.println(String.join("", Collections.nCopies(32, "-")));
        System.out.println(bi_z);
        System.out.println(bi_a);
        System.out.println(bi_b);
        System.out.println(bi_c);
    }
}

