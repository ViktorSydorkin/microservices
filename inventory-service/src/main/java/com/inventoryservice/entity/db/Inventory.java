package com.inventoryservice.entity.db;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Inventory {
    @Id
    private String inventoryId;
    private String itemName;
    private int price;
    private int amount;
}
