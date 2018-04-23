package com.jjkj.administrator.storecontrollersystem.utils.pull;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({FIELD, METHOD, PARAMETER})
public @interface PullXmlElement {
    String tagName();

    int tagId();

    boolean isNeed() default true;
}
