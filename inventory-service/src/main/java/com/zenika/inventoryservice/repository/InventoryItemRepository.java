package com.zenika.inventoryservice.repository;

import com.zenika.inventoryservice.entity.InventoryItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItems, String> {

    Optional<InventoryItems> findByproductCode(String productCode);
}
