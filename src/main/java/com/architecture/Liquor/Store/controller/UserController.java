package com.architecture.Liquor.Store.controller;

import com.architecture.Liquor.Store.dto.UserDto;
import com.architecture.Liquor.Store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public List<UserDto> getUser(){

        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @PutMapping("/updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUser(@RequestBody UserDto userDto){
        return userService.deleteUser(userDto);
    }

}
