package com.example.demo.mytest;

import java.util.concurrent.locks.ReentrantLock;

public class RT {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("线程一尝试获取锁");
                reentrantLock.lockInterruptibly();
                System.out.println("线程一拿到锁");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("线程二尝试获取锁");
//                reentrantLock.lock();

                reentrantLock.lockInterruptibly();
                System.out.println("线程二拿到锁");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();
        thread2.interrupt();
        thread1.interrupt();


    }
}
