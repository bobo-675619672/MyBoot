package com.dw.boot.s1.annotation;

import java.lang.annotation.*;

/**
 * @author Administrator
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerStudyType {

    /**
     * 学习类型
     * @return
     */
    String value();

}
