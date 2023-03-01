package com.productservice.entity.mapper;

import com.productservice.entity.db.Product;
import com.productservice.entity.dto.ProductDto;
import com.productservice.entity.dto.ProductPostDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDto toDto(Product product);
    Product fromDto(ProductDto productDto);

    ProductPostDto toPostDto(Product product);
    Product fromPostDto(ProductPostDto productPostDto);

}
