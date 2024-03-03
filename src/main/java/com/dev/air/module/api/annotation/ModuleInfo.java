package com.dev.air.module.api.annotation;

import com.dev.air.module.api.Category;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleInfo {

    String name();
    String description();
    int key() default 0;
    Category category();
    boolean autoEnable() default false;
    boolean hidden() default false;

}
