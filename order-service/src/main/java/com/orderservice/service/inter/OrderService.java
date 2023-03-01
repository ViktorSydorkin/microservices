package com.orderservice.service.inter;

import com.orderservice.entity.dto.OrderDto;
import com.orderservice.entity.dto.OrderPostDto;

import java.util.List;

public interface OrderService {
    OrderDto create(OrderPostDto orderPostDto);
    List<OrderDto> findAll();
}
