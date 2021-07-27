package sample;

import java.lang.reflect.Field;
import java.util.Collections;

/**
 * @ClassName: BitOperation
 * @Author: �ƺ�
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
        // �����ȡ�ֶ�
        Field[] fields = bitOperation_reflect.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());

            // ��ʹ�÷����ٰ� bi_* ֵȡ����
            Object bi_ = field.get(bitOperation_reflect);
            System.out.println(bi_.toString());
            System.out.println(Integer.toBinaryString((Integer) bi_));
            // ����name��Ա������private, ������Ҫ���з���Ȩ���趨
            //field.setAccessible(true);
            System.out.println(bitOperation_reflect.getClass().isAssignableFrom(BitOperation_reflect.class));
            // ʹ�÷�����и�ֵ
            //��.............. ����̫��, ѧһѧ mooc����Ƶ ֮���ٻ���
            field.set(bitOperation_reflect, "���");
            System.out.println(String.join("", Collections.nCopies(32, "-")));
        }


    }
}

