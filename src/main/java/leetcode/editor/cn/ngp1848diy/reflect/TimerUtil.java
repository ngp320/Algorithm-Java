package leetcode.editor.cn.ngp1848diy.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 配合 Timer使用, 使用方式如下, 打印 使用时间.
 * 还算好用, 暂时找不到更好的 =.=
 * 不完美, 数组拷贝, 或者创建的时间都算在程序里了
 *     @Timer
 *     void shellSortTest() {
 *         int[] arr = generateRandomArray(100000);
 *         sort(arr);
 *     }
 *     public static void main(String[] args) {
 *         TimerUtil timerUtil = new TimerUtil();
 *         timerUtil.getTime();
 *     }
 */
public class TimerUtil {

    public void getTime() {
        // 获取当前类型名字
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        System.out.println("current className(expected): " + className);
        try {
            Class c = Class.forName(className);
            Object obj = c.newInstance();
            //Method[] methods = c.getDeclaredMethods();
            //排序
            List<Method> methods = getOrderedMethod(c.getDeclaredMethods());

            for (Method m : methods) {
                // 判断该方法是否包含Timer注解
                if (m.isAnnotationPresent(Timer.class)) {
                    m.setAccessible(true);
                    Long start = System.nanoTime(); // 纳秒
                    //long start = System.currentTimeMillis();
                    // 执行该方法
                    m.invoke(obj);
                    Long end = System.nanoTime(); // 纳秒
                    //long end = System.currentTimeMillis();
                    System.out.println(m.getName() + "() time consumed: " + String.format("%.2f",(end - start)/Math.pow(10,6)) + "ms");
                    //System.out.println(m.getName() + "() time consumed: " + String.valueOf((end - start)/1000) + "ms");
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
    private List<Method> getOrderedMethod(Method[] methods){
        // 用来存放所有的属性域
        List<Method> methodList = new ArrayList<>();
        // 过滤带有注解的Field
        for(Method m: methods){
            if(m.getAnnotation(Timer.class)!=null){
                methodList.add(m);
            }
        }
        // 这个比较排序的语法依赖于java 1.8
        methodList.sort(Comparator.comparingInt(
                m -> m.getAnnotation(Timer.class).order()
        ));
        return methodList;
    }
}
