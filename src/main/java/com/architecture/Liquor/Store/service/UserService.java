package com.architecture.Liquor.Store.service;

import com.architecture.Liquor.Store.dto.UserDto;
import com.architecture.Liquor.Store.entity.User;
import com.architecture.Liquor.Store.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    public UserDto saveUser(UserDto userDto){
        userRepository.save(modelMapper.map(userDto, User.class));
        return userDto;
    }
}
