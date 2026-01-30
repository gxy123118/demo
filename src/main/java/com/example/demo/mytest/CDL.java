package com.example.demo.mytest;

import java.util.concurrent.CountDownLatch;

public class CDL {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c1=new CountDownLatch(1);
        CountDownLatch c2=new CountDownLatch(1);
        new Thread(()->{
            System.out.println("任务1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            c1.countDown();
        }).start();
        new Thread(()->{
            try {
                c1.await();
                System.out.println("任务2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            c2.countDown();
        }).start();

        c2.await();
        System.out.println("main");
    }
}
