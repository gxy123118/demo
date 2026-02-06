package com.example.demo.mytest;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.*;

public class TE {
    public static void main(String[] args) {
        // 配置线程池参数
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,                  // corePoolSize：核心线程数2
                5,                  // maximumPoolSize：最大线程数5
                30,                 // keepAliveTime：非核心线程空闲30秒销毁
                SECONDS,   // 时间单位：秒
                new ArrayBlockingQueue<>(1), // 任务队列：有界队列，容量3
                Executors.defaultThreadFactory(), // 默认线程工厂
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        // 提交8个任务（核心2 + 队列3 + 非核心2 = 7，第8个触发拒绝策略）
        for (int i = 1; i <= 8; i++) {
            int taskId = i;
            try {
                executor.execute(() -> {
                    System.out.println("任务" + taskId + "由线程" + Thread.currentThread().getName() + "执行");
                    try {
                        Thread.sleep(5000);
                        System.out.println("任务" + taskId + "由线程" + Thread.currentThread().getName() + "执行完了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (RejectedExecutionException e) {
                System.out.println("任务" + taskId + "被拒绝：" + e.getMessage());
            }
        }

        // 关闭线程池
        executor.shutdown();

//        ArrayBlockingQueue	是	FIFO，并发中等，可控	高并发、需限制队列容量	容量过小易触发拒绝策略
//        LinkedBlockingQueue	可选	FIFO，并发好，默认无界	任务量可控、提交速度慢	无界模式易 OOM，maxPoolSize 失效
//        SynchronousQueue	无容量	即时传递，并发最优	任务即时执行、短时间突发任务	易创建大量线程导致 OOM
//        PriorityBlockingQueue	无	按优先级执行，非 FIFO	任务有优先级区分	无界易 OOM，排序有性能开销
//        DelayQueue	无	延迟执行，非 FIFO	定时 / 延迟任务	无界易 OOM，不适合高频任务
    }
}
