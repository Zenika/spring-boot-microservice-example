package com.zenika.inventoryservice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "inventoryitems")
public class InventoryItems {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String productCode;
    @Column(nullable = false)
    private Long availableQuantity;
}
