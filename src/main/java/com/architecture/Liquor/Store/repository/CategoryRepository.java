package com.architecture.Liquor.Store.repository;

import com.architecture.Liquor.Store.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // You can add custom query methods if needed
}
