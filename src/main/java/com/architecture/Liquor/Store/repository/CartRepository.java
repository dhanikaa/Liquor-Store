package com.architecture.Liquor.Store.repository;

import com.architecture.Liquor.Store.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
