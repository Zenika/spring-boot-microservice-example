package com.zenika.catalogservice.service;

import com.zenika.catalogservice.entity.Products;
import com.zenika.catalogservice.repository.ProductRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    public ProductService(ProductRepository productRepository, RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }

    public List<Products> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Products> findProductByCode(String code) {
        Optional<Products> productsOptional = productRepository.findByCode(code);
        if (productsOptional.isPresent()) {
            ResponseEntity<ProductInventoryResponse> responseEntity =
                    restTemplate.getForEntity(
                            "http://inventory-service/api/inventory/{code}",
                            ProductInventoryResponse.class,
                            code
                    );
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                Long quantity = responseEntity.getBody().getAvailableQuantity();
                productsOptional.get().setInStock(quantity > 0);
            }
        }
        return productsOptional;
    }

}
    @Data
    class ProductInventoryResponse {
        private Long id;
        private String productCode;
        private Long availableQuantity;
    }
