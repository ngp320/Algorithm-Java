package leetcode.editor.cn.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * �ɰ汾ͳ��ʱ��
 * �°汾���� ===���ȱ�ʾʱ�䳤��
 */
public class TimerUtil {

    public void getTime() {
        // ��ȡ��ǰ��������
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        System.out.println("current className(expected): " + className);
        try {
            Class c = Class.forName(className);
            Object obj = c.newInstance();
            Method[] methods = c.getDeclaredMethods();
            for (Method m : methods) {
                // �жϸ÷����Ƿ����Timerע��
                if (m.isAnnotationPresent(Timer.class)) {
                    m.setAccessible(true);
                    long start = System.currentTimeMillis();
                    // ִ�и÷���
                    m.invoke(obj);
                    long end = System.currentTimeMillis();
                    System.out.println(m.getName() + "() time consumed: " + String.valueOf(end - start) + "ms");
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
