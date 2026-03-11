package com.example.demo.annotation;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationA {
    String value() default "aaa";

}
