package com.inventoryservice.controller;

import com.inventoryservice.entity.dto.InventoryDto;
import com.inventoryservice.entity.dto.InventoryPostDto;
import com.inventoryservice.service.inter.InventoryService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    InventoryDto create(@RequestBody @Valid InventoryPostDto inventoryPostDto){
        return inventoryService.create(inventoryPostDto);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    List<InventoryDto> findAll(){
        return inventoryService.findAll();
    }

    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    List<InventoryDto> findByName(@PathVariable String name){
        return inventoryService.findByName(name);
    }
    @GetMapping("/available/{name}")
    @ResponseStatus(HttpStatus.OK)
   Boolean isItemAvailable(@PathVariable String name){
        return inventoryService.isItemAvailable(name);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
   List<InventoryDto> areItemsAvailable(@RequestParam(value = "name") List<String> names){
        return inventoryService.findAllByNames(names);
    }
}
