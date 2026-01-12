package com.example;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;


@RestController
@RequestMapping

public class WebFluxController {


    @GetMapping("/")
    public Flux<String> index(String[] strings) {

        Flux<String> stringFlux = Flux.just(strings);
        stringFlux.flatMap(string -> singleApiToFlux(string));
        return stringFlux;
    }

    public Mono<String> asyncApi(String input) {
        return Mono.delay(java.time.Duration.ofSeconds(3))
                .publishOn(Schedulers.boundedElastic()) // 仅当有不可避免的同步操作时用
                .map(tick -> input + "输出"); // 模拟 API 处理结果
    }

    // 正确：异步非阻塞的核心方法
    public Flux<String> singleApiToFlux(String input) {
        // 调用异步 API 方法，得到 Mono<String>（真正的 API 结果）
        Mono<String> apiResultMono = asyncApi(input);
        // 把 Mono 转成 Flux 返回（由最终消费者订阅，比如控制器）
        return apiResultMono.flux();
    }

}
