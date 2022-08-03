package com.waer.wblog.annoation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SuppressWarnings("all")
/**
 * @author: Tisox
 * @date: 2022/6/19 22:34
 * @description:
 * @blog:www.waer.ltd
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface topwd {
    //其他逻辑
}
