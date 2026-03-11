package com.example.demo.inter;

public interface InterfaceA {

    default void print() {
        System.out.println("InterfaceA");
    }

    static void print1() {
        System.out.println("InterfaceA");
    }

}
