package com.zenika.catalogservice.service;

import com.zenika.catalogservice.entity.Products;
import com.zenika.catalogservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Products> findAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Products> findProductByCode(String code){
        return productRepository.findByCode(code);
    }
}
