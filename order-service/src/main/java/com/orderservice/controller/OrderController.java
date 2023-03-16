package com.orderservice.controller;

import com.orderservice.entity.dto.OrderDto;
import com.orderservice.entity.dto.OrderPostDto;
import com.orderservice.service.inter.OrderService;
import javax.validation.Valid;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @CircuitBreaker(name="inventory", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name="inventory")
    @Retry(name = "inventory")
    @ResponseStatus(HttpStatus.CREATED)
    CompletableFuture<OrderDto> create(@RequestBody @Valid OrderPostDto orderPostDto) {
        return CompletableFuture.supplyAsync(()->orderService.create(orderPostDto));
    }

    public CompletableFuture<String> fallbackMethod(RuntimeException runtimeException){
        return CompletableFuture.supplyAsync(()-> "Oops! Something went wrong, please try again later!");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<OrderDto> findAll() {
        return orderService.findAll();
    }

}
