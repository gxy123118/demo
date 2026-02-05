package com.example.demo.mytest;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class SEMP {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(2);
        long l = System.currentTimeMillis();
        System.out.println(l);
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
