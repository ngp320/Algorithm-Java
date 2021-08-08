package leetcode.editor.cn.ngp1848diy.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Timer {
    int order();
}
