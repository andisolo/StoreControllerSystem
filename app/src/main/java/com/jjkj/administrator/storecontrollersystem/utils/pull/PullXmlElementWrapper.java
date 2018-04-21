package com.jjkj.administrator.storecontrollersystem.utils.pull;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 注解生成XML属性
 */
@Retention(RUNTIME)
@Target({FIELD, METHOD, PARAMETER})
public @interface PullXmlElementWrapper {
    /**
     * tag
     *
     * @return tag名称
     */
    String attributeName() default "##default";

    String attributeValue() default "##default";

    String tagName();
}
