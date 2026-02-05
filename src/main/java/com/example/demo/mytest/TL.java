package com.example.demo.mytest;

import java.util.concurrent.locks.ReentrantLock;

public class TL {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock=new ReentrantLock();
        Thread t = new Thread(() -> {
            lock.lock();
            System.out.println("t抢到锁");
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            lock.unlock();
        });
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                System.out.println("t1抢到锁");
            } catch (InterruptedException e) {
                throw new RuntimeException("中断");
            }
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            lock.unlock();
        });

        t.start();
        t1.start();
        t1.interrupt();
    }
}
