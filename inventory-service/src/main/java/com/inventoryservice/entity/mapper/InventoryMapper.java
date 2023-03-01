package com.inventoryservice.entity.mapper;

import com.inventoryservice.entity.db.Inventory;
import com.inventoryservice.entity.dto.InventoryDto;
import com.inventoryservice.entity.dto.InventoryPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    InventoryDto toDto(Inventory inventory);
    Inventory fromDto(InventoryDto inventoryDto);

    InventoryPostDto roPostDto(Inventory inventory);
    Inventory fromPostDto(InventoryPostDto inventoryPostDto);
}
