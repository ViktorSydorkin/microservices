package com.orderservice.controller;

import com.orderservice.entity.dto.OrderDto;
import com.orderservice.entity.dto.OrderPostDto;
import com.orderservice.service.inter.OrderService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    OrderDto create(@RequestBody @Valid OrderPostDto orderPostDto) {
        return orderService.create(orderPostDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<OrderDto> findAll() {
        return orderService.findAll();
    }

}
