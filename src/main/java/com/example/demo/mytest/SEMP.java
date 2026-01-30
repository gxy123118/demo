package com.example.demo.mytest;

import java.util.concurrent.Semaphore;

public class SEMP {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(2);

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("获取");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
