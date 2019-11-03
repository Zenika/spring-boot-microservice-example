package com.zenika.inventoryservice.service;

import com.zenika.inventoryservice.entity.InventoryItems;
import com.zenika.inventoryservice.repository.InventoryItemRepository;
import org.springframework.stereotype.Service;

@Service
public class InventoryItemService {
    private final InventoryItemRepository inventoryItemRepository;

    public InventoryItemService(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public InventoryItems findInventoryItemByCode(String code){
        return inventoryItemRepository.findByproductCode(code)
                .orElse(new InventoryItems());
    }
}
