package com.orderservice.entity.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Long id;
    private String name;
    private int amount;
    private Long productId;
}
