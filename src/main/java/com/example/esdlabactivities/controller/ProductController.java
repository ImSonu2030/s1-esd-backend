package com.example.esdlabactivities.controller;

import com.example.esdlabactivities.dto.ProductRequest;
import com.example.esdlabactivities.entity.Product;
import com.example.esdlabactivities.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody @Valid ProductRequest request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(
            @RequestParam(value = "min", required = false) Integer min,
            @RequestParam(value = "max", required = false) Integer max
    ) {
        if (min != null && max != null) {
            return ResponseEntity.ok(productService.getTopTwoProductsInPriceRange(min, max));
        }

        return ResponseEntity.ok(productService.getAllProducts());
    }
}
