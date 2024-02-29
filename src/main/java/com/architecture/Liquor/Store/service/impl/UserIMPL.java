package com.architecture.Liquor.Store.Service.impl;

import com.architecture.Liquor.Store.Dto.UserDTO;
import com.architecture.Liquor.Store.Entity.User;
import com.architecture.Liquor.Store.Repo.UserRepo;
import com.architecture.Liquor.Store.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserIMPL implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;


    @Override
    public String addUser(UserDTO userDTO) {


        User user = new User(
                userDTO.getUserid(),
                userDTO.getUsername(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );
        userRepo.save(user);
        return user.getUsername();







    }
}
