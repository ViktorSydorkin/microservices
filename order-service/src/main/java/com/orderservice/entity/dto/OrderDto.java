package com.orderservice.entity.dto;

import com.orderservice.entity.db.Item;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @Positive
    long orderId;
    @NotNull
    Timestamp orderTime;
    @NotNull List<ItemDto> items;
}
