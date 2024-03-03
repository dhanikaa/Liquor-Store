package com.architecture.Liquor.Store.Repo;

import com.architecture.Liquor.Store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
