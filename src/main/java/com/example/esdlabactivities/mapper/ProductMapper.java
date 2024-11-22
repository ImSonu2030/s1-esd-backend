package com.example.esdlabactivities.mapper;

import com.example.esdlabactivities.dto.ProductRequest;
import com.example.esdlabactivities.dto.ProductResponse;
import com.example.esdlabactivities.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toEntity(final ProductRequest request) {
        return Product.builder()
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .build();
    }

    public ProductResponse toResponse(final Product entity) {
        return new ProductResponse(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice()
        );
    }
}
