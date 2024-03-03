package com.architecture.Liquor.Store.controller;

import com.architecture.Liquor.Store.dto.UserDto;
import com.architecture.Liquor.Store.entity.User;
import com.architecture.Liquor.Store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3006")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signupUser(@RequestBody UserDto userDto) {
        User createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody UserDto userDto) {
        User existingUser = userService.getUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getPassword().equals(userDto.getPassword())) {
            // Successfully logged in
            return ResponseEntity.ok(existingUser);
        } else {
            // Invalid login credentials
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
}
