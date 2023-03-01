package com.inventoryservice.service.inter;

import com.inventoryservice.entity.dto.InventoryDto;
import com.inventoryservice.entity.dto.InventoryPostDto;

import java.util.List;

public interface InventoryService {
    InventoryDto create(InventoryPostDto inventoryPostDto);
    List<InventoryDto> findAll();
    List<InventoryDto> findByName(String name);
    Boolean isItemAvailable(String name);
    List<InventoryDto> findAllByNames(List<String> names);
}
