package com.zenika.catalogservice.controller;

import com.zenika.catalogservice.entity.Products;
import com.zenika.catalogservice.exception.ProductNotFoundException;
import com.zenika.catalogservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Products> getAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{code}")
    public Products findProductByCode(@PathVariable String code) {
        return productService
                .findProductByCode(code)
                .orElseThrow(() -> new ProductNotFoundException("Products with code: " + code + " was not found"));
    }
}
