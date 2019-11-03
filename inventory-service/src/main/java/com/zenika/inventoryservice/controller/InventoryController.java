package com.zenika.inventoryservice.controller;

import com.zenika.inventoryservice.entity.InventoryItems;
import com.zenika.inventoryservice.service.InventoryItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/inventory")
@Slf4j
public class InventoryController {

    private final InventoryItemService inventoryItemService;

    public InventoryController(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    @GetMapping("{code}")
    public ResponseEntity<InventoryItems> findInventoryItemByProductCode(@PathVariable String code){
        log.info("Finding inventory item for code: " + code);
        InventoryItems inventoryItem = inventoryItemService.findInventoryItemByCode(code);
        if(inventoryItem != null){
            return new ResponseEntity(inventoryItem, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
