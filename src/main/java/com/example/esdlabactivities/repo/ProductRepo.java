package com.example.esdlabactivities.repo;

import com.example.esdlabactivities.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.price between :priceMin and :priceMax order by p.price desc limit 2")
    List<Product> findTopTwoByPriceDescAndPriceBetween(@Param("priceMin")Double priceMin, @Param("priceMax")Double priceMax);
}
