package com.first.testgit.utils.anno;

import com.first.testgit.modules.limitliu.LimitType;

import java.lang.annotation.*;

/**
 * @author:jiaxingxu
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Limit {

    // 资源名称，用于描述接口功能
    String name() default "";

    // 资源 key
    String key() default "";

    // key prefix
    String prefix() default "";

    // 时间的，单位秒
    int period();

    // 限制访问次数
    int count();

    // 限制类型
    LimitType limitType() default LimitType.CUSTOMER;

}