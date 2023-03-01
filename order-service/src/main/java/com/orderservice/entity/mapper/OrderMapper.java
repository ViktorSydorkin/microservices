package com.orderservice.entity.mapper;

import com.orderservice.entity.db.Order;
import com.orderservice.entity.dto.OrderDto;
import com.orderservice.entity.dto.OrderPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ItemMapper.class})
public interface OrderMapper {
OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

OrderDto toDto(Order order);
Order fromDto(OrderDto orderDto);

OrderPostDto toPostDto(Order order);
Order fromPostDto(OrderPostDto orderPostDto);
}
