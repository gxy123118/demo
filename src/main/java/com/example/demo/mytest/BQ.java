package com.example.demo.mytest;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BQ {


    ArrayList<Integer> list = new ArrayList<>();
    int count = 5;
    ReentrantLock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();


    public void put(int val) {
        lock.lock();
        try {
            while (list.size() == 5) {
                notFull.await();
            }
            list.add(val);
            notEmpty.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
