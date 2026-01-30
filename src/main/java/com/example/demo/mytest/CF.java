package com.example.demo.mytest;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CF {

    public static void main(String[] args) throws InterruptedException {
        long mainStart = System.currentTimeMillis();
//        CompletableFuture.supplyAsync(() -> {
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    System.out.println("【" + Thread.currentThread().getName() + "】supplyAsync 执行时间：" + System.currentTimeMillis());
//                    return "result";
//                })
//                .thenApply(r -> {
//
//                    System.out.println("【" + Thread.currentThread().getName() + "】thenApply 执行时间：" + System.currentTimeMillis());
//                    return "handler" + r;
//                })
//                .thenAccept(r -> {
//                    System.out.println("【" + Thread.currentThread().getName() + "】thenAccept 开始休眠，时间：" + System.currentTimeMillis());
//                    System.out.println("【" + Thread.currentThread().getName() + "】aahandlerresult 打印时间：" + System.currentTimeMillis());
//                    System.out.println("aa" + r);
//                });
//
//        // 主线程打印，添加时间戳
//        System.out.println("【" + Thread.currentThread().getName() + "】main 打印时间：" + System.currentTimeMillis() + "，耗时：" + (System.currentTimeMillis() - mainStart) + "ms");
//        System.out.println("main");
//        Thread.sleep(80000);
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "任务一结果";
        });
        CompletableFuture<String> stringCompletableFuture1 = stringCompletableFuture.thenApply((e) -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException i) {
                throw new RuntimeException(i);
            }
            return "任务二结果-"+e;
        });
        CompletableFuture<Void> stringCompletableFuture2 = stringCompletableFuture1.thenAccept((e) -> {
            System.out.println("任务三接收结果-" + e);
        });

        System.out.println("main");
        Thread.sleep(5000);
    }
}
