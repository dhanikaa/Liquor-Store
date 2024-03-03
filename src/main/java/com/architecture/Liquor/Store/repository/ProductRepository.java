package com.architecture.Liquor.Store.repository;

import com.architecture.Liquor.Store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // You can add custom query methods if needed
}
