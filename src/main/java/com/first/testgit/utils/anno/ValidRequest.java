package com.first.testgit.utils.anno;

import java.lang.annotation.*;

/**
 * @author:jiaxingxu
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ValidRequest {
}
