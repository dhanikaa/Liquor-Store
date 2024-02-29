package com.architecture.Liquor.Store.repository;

import com.architecture.Liquor.Store.entity.CartItem;
import com.architecture.Liquor.Store.entity.Oder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderRepository extends JpaRepository<Oder,Integer> {
}
