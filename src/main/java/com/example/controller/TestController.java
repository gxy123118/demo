package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/vm-status")
    public Mono<String> getVmStatus(@RequestParam int vmId) {
        return Mono.fromCallable(() -> {
                    return "VM " + vmId + " is running";
                })
                .map(
                        status -> "VM " + vmId + " is running"
                );
    }
}
