package com.example.demo.mytest;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABA {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2);
        atomicInteger.compareAndSet(2,3);
        System.out.println(atomicInteger);

    }
}
