package com.productservice.controller;

import com.productservice.entity.dto.ProductDto;
import com.productservice.entity.dto.ProductPostDto;
import com.productservice.services.inter.ProductService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto create(@RequestBody @Valid ProductPostDto productPostDto){
        return productService.create(productPostDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> findAll(){
        return productService.findAll();
    }
}
