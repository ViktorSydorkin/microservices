package com.orderservice.entity.mapper;

import com.orderservice.entity.db.Item;
import com.orderservice.entity.db.Order;
import com.orderservice.entity.dto.OrderDto;
import com.orderservice.entity.dto.OrderPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper(uses = {ItemMapper.class})
public interface OrderMapper {
  OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

  OrderDto toDto(Order order);

  Order fromDto(OrderDto orderDto);

  OrderPostDto toPostDto(Order order);

  Order fromPostDto(OrderPostDto orderPostDto);

//  default Order fromPostDto(OrderPostDto orderPostDto) {
//    return Order.builder()
//        .orderTime(orderPostDto.getOrderTime())
//        .items(
//            orderPostDto.getItemIds().stream()
//                .map(item -> Item.builder().id(item).build())
//                .collect(Collectors.toList()))
//        .build();
//  }
}
