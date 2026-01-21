package com.example.invoke;

import com.example.demo.mytest.An;
import org.springframework.beans.factory.annotation.Autowired;

public class User {
    @Autowired
    private int a = 3;
    public static int c=4;

    public int getA() {
        return a;
    }
    public static void m1(){
        System.out.println("1");
    }
}
