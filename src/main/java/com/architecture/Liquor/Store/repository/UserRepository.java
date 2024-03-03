package com.architecture.Liquor.Store.repository;

import com.architecture.Liquor.Store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
