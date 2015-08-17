package com.stonegate.tianna.common.annotations;

import java.lang.annotation.*;

/**
 * @author chao.zhu created on 15/3/18 下午10:06
 * @version 1.0
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Record {
    /**
     * record cost time if more than this value, will not record cost if the value is less than 0
     *
     * @return
     */
    int cost() default 1000;

    /**
     * record the result after execution if true
     *
     * @return
     */
    boolean result() default false;

    Class logger() default Record.class;// if this value not specified,use the default

    String success() default ""; // record monitor if success

    String error() default ""; // record monitor if error
}
