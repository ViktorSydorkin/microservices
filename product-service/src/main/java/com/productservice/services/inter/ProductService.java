package com.productservice.services.inter;

import com.productservice.entity.dto.ProductDto;
import com.productservice.entity.dto.ProductPostDto;

import java.util.List;

public interface ProductService {
    ProductDto create(ProductPostDto productPostDto);
    List<ProductDto> findAll();
}
