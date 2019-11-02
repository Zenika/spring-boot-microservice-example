package com.zenika.catalogservice.repository;

import com.zenika.catalogservice.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products, Long> {
    Optional<Products> findByCode(String code);
}
