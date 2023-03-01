package com.productservice.services.impl;

import com.productservice.entity.dto.ProductDto;
import com.productservice.entity.dto.ProductPostDto;
import com.productservice.entity.mapper.ProductMapper;
import com.productservice.repository.inter.ProductRepository;
import com.productservice.services.inter.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  @Override
  public ProductDto create(ProductPostDto productPostDto) {
    return ProductMapper.INSTANCE.toDto(
        productRepository.save(ProductMapper.INSTANCE.fromPostDto(productPostDto)));
  }

  @Override
  public List<ProductDto> findAll() {
    return productRepository.findAll().stream().map(ProductMapper.INSTANCE::toDto).collect(Collectors.toList());
  }
}
