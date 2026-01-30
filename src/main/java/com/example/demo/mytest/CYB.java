package com.example.demo.mytest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CYB {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        //一组线程同时等待
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Thread.sleep(2000);
                    cyclicBarrier.await();
                    System.out.println(finalI);
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
