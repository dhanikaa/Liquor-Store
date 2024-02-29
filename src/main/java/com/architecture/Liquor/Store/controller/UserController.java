package com.architecture.Liquor.Store.controller;

import com.architecture.Liquor.Store.dto.UserDto;
import com.architecture.Liquor.Store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1/user")
@CrossOrigin
public class UserController {

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDto userDto)
    {
        String id = userService.addUser(userDto);
        return id;
    }
}
