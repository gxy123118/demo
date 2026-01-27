package com.example.invoke;

import com.example.demo.mytest.An;
import org.springframework.beans.factory.annotation.Autowired;

public class User implements Comparable<User> {
    @Autowired
    private int a = 3;
    public static int c = 4;
    public int b = 5;

    public int age;

    public User(int age) {
        this.age = age;
    }

    public int getA() {
        return a;
    }

    public static void m1() {
        System.out.println("1");
    }

    @Override
    public int compareTo(User o) {
        return this.age-o.age;
    }
}
