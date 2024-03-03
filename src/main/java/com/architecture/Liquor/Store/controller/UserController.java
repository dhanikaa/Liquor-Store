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
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{uid}")
    public ResponseEntity<User> getUserById(@PathVariable int uid) {
        User user = userService.getUserById(uid);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{uid}")
    public ResponseEntity<User> updateUser(@PathVariable int uid, @RequestBody UserDto userDto) {
        User updatedUser = userService.updateUser(uid, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Void> deleteUser(@PathVariable int uid) {
        userService.deleteUser(uid);
        return ResponseEntity.noContent().build();
    }
}
