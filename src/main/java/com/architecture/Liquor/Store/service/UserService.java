package com.architecture.Liquor.Store.service;

import com.architecture.Liquor.Store.dto.UserDto;
import com.architecture.Liquor.Store.entity.User;
import com.architecture.Liquor.Store.exception.UserNotFoundException;
import com.architecture.Liquor.Store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int uid) {
        return userRepository.findById(uid)
                .orElseThrow(() -> new UserNotFoundException("User with id " + uid + " not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(UserDto userDto) {
        User user = new User();
        mapDtoToEntity(userDto, user);
        return userRepository.save(user);
    }

    public User updateUser(int uid, UserDto userDto) {
        User existingUser = getUserById(uid);
        mapDtoToEntity(userDto, existingUser);
        return userRepository.save(existingUser);
    }

    public void deleteUser(int uid) {
        userRepository.deleteById(uid);
    }

    private void mapDtoToEntity(UserDto userDto, User user) {
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setTelephone(userDto.getTelephone());
        user.setAddress(userDto.getAddress());
        user.setPassword(userDto.getPassword());
        user.setConfirmPassword(userDto.getConfirmPassword());
    }
}
