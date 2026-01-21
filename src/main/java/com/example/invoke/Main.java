package com.example.invoke;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> c= Class.forName("com.example.invoke.User");
        Constructor<?> constructor = c.getConstructor();
        User o =(User) constructor.newInstance();
        System.out.println(o.getA());
        Field a = c.getDeclaredField("a");
        System.out.println(a.getName()+a.getType());
        Field c1 = c.getField("c");
//        c1.setAccessible(true);
        System.out.println(c1.get(null));
//        c1.getAnnotation();
        Method m1 = c.getMethod("m1");
        Object invoke = m1.invoke(null);
        System.out.println(invoke);



    }
}
