package com.inventoryservice.service.impl;

import com.inventoryservice.entity.dto.InventoryDto;
import com.inventoryservice.entity.dto.InventoryPostDto;
import com.inventoryservice.entity.mapper.InventoryMapper;
import com.inventoryservice.repository.InventoryRepository;
import com.inventoryservice.service.inter.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
  private final InventoryRepository inventoryRepository;

  @Override
  public InventoryDto create(InventoryPostDto inventoryPostDto) {
    return InventoryMapper.INSTANCE.toDto(
        inventoryRepository.save(InventoryMapper.INSTANCE.fromPostDto(inventoryPostDto)));
  }

  @Override
  public List<InventoryDto> findAll() {
    return inventoryRepository.findAll().stream()
        .map(InventoryMapper.INSTANCE::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public List<InventoryDto> findByName(String name) {
    return inventoryRepository.findAllByItemName(name).stream()
        .map(InventoryMapper.INSTANCE::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public Boolean isItemAvailable(String name) {
    return inventoryRepository.existsByItemName(name);
  }

  @Override
  public List<InventoryDto> findAllByNames(List<String> names) {
    return inventoryRepository.findAllByItemNameIn(names).stream()
        .map(InventoryMapper.INSTANCE::toDto)
        .collect(Collectors.toList());
  }
}
