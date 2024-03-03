package com.architecture.Liquor.Store.repository;

import com.architecture.Liquor.Store.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    // You can add custom query methods if needed
}
