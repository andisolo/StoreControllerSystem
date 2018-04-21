package com.jjkj.administrator.storecontrollersystem.utils.pull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PullXmlSpaceNameList {
    String nameUrl() default "";

    String prefix() default "";
}
