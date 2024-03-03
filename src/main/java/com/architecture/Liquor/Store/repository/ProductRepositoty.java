package com.architecture.Liquor.Store.repository;


import com.architecture.Liquor.Store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepositoty  extends JpaRepository<Product,Integer> {
}
