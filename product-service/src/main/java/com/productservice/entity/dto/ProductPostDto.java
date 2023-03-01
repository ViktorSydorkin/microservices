package com.productservice.entity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPostDto {
    @NotBlank
    String name;
    @PositiveOrZero
    int price;
}
