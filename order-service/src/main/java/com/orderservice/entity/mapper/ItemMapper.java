package com.orderservice.entity.mapper;

import com.orderservice.entity.db.Item;
import com.orderservice.entity.dto.ItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDto toDto(Item item);
    Item fromDto(ItemDto itemDto);
}
