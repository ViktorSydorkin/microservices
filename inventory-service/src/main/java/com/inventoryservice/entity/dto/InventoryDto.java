package com.inventoryservice.entity.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {
   @NotBlank
   String inventoryId;
   @NotBlank
   String itemName;
   @PositiveOrZero
   int price;
   @PositiveOrZero
   int amount;
}
