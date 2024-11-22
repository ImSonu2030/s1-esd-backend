package com.example.esdlabactivities.service;

import com.example.esdlabactivities.dto.ProductRequest;
import com.example.esdlabactivities.entity.Product;
import com.example.esdlabactivities.mapper.ProductMapper;
import com.example.esdlabactivities.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;
    private final ProductRepo productRepo;

    public String createProduct(ProductRequest request) {
        Product product = productMapper.toEntity(request);
        productRepo.save(product);
        return "Product created";
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> getTopTwoProductsInPriceRange(double priceMin, double priceMax) {
        return productRepo.findTopTwoByPriceDescAndPriceBetween(priceMin, priceMax);
    }
}
