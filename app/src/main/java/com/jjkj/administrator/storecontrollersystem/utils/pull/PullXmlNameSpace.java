package com.jjkj.administrator.storecontrollersystem.utils.pull;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.xml.bind.annotation.XmlRootElement;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@XmlRootElement
@Retention(RUNTIME)
@Target(TYPE)
public @interface PullXmlNameSpace {
    PullXmlSpaceNameList[] spaceNameList() default {};
}
