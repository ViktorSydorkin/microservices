package com.inventoryservice.repository;

import com.inventoryservice.entity.db.Inventory;
import com.inventoryservice.entity.dto.InventoryDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {
    List<Inventory> findAllByItemName(String name);
    Boolean existsByItemName(String name);
    List<Inventory> findAllByItemNameIn(List<String> names);
}
