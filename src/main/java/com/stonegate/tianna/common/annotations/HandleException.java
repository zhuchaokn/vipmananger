package com.stonegate.tianna.common.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author chao.zhu created on 15/4/2 下午8:32
 * @version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface HandleException {
    Class<? extends Exception> value();
}
