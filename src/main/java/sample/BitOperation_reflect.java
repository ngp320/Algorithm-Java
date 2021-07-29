package sample;

import java.lang.reflect.Field;
import java.util.Collections;

/**
 * @ClassName: BitOperation
 * @Author: 唐浩
 * @Date: 2021/7/23 11:15
 */
public class BitOperation_reflect {
    int z = -5;
    int a = 5 >> 3;
    int b = -5 >> 3;
    int c = -5 >>> 3;
    //String bi_z = Integer.toBinaryString(z);
    //String bi_a = Integer.toBinaryString(a);
    //String bi_b = Integer.toBinaryString(b);
    //String bi_c = Integer.toBinaryString(c);

    public static void main(String[] args) throws IllegalAccessException {
        BitOperation_reflect bitOperation_reflect = new BitOperation_reflect();
        // 反射获取字段
        Field[] fields = bitOperation_reflect.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());

            // 再使用反射再把 bi_* 值取出来
            Object bi_ = field.get(bitOperation_reflect);
            System.out.println(bi_.toString());
            System.out.println(Integer.toBinaryString((Integer) bi_));
            // 由于name成员变量是private, 所以需要进行访问权限设定
            //field.setAccessible(true);
            System.out.println(bitOperation_reflect.getClass().isAssignableFrom(BitOperation_reflect.class));
            // 使用反射进行赋值
            //诶.............. 好像不太行, 学一学 mooc网视频 之后再回来
            field.set(bitOperation_reflect, "你好");
            System.out.println(String.join("", Collections.nCopies(32, "-")));
        }


    }
}

