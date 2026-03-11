package com.example.demo.annotation;

public class Main {
    public static void main(String[] args) {
        Class<ClassA> classAClass = ClassA.class;
        AnnotationA annotationA = classAClass.getAnnotation(AnnotationA.class);
        System.out.println(annotationA.value());

    }
}
