package com.demo.jdbctemplate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/18 11:12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Pk {

    boolean auto() default true;
}
