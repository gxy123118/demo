package com.example;

public class SingleTon {

    private volatile Object o;


    public Object getInstance() {
        if (o == null) {
            synchronized (SingleTon.class) {
                if (o == null) {
                    o = new Object();
                }
            }
        }
        return o;
    }

}
