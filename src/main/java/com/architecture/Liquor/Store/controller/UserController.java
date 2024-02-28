package com.architecture.Liquor.Store.controller;

import com.architecture.Liquor.Store.dto.UserDto;
import com.architecture.Liquor.Store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public String getUser(){

        return "User Created";
    }

    @PostMapping("/saveUser")
    public UserDto saveUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @PutMapping("/updateUser")
    public String updateUser(){

        return "User Updated";
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(){

        return "User deleted";
    }

}
