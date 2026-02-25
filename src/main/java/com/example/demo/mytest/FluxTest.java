package com.example.demo.mytest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class FluxTest {
    public static void main(String[] args) {

        Flux<String> status = getStatus();

        status.subscribe(System.out::println);
    }

    public static Flux<String> getStatus() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        Flux<String> stringFlux = Flux.fromIterable(list)
                .map(id -> {
                    String s = queryVmStatus(Integer.parseInt(id));

                    return s;
                });
        System.out.println("main");
        return stringFlux;
    }

    // 模拟查询虚拟机状态的耗时操作
    private static String queryVmStatus(int vmId) {
        try {
            System.out.println("queryVmStatus");
            // 模拟虚拟机状态查询耗时 2 秒
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "VM-" + vmId + " is Running";  // 返回虚拟机的状态
    }
}

