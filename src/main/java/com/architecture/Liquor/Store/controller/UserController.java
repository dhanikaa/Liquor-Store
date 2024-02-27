package com.architecture.Liquor.Store.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="api/v1/user")
@CrossOrigin
public class UserController {

    @GetMapping("/getUser")
    public String getUser(){

        return "User Created";
    }

    @PostMapping("/saveUser")
    public String saveUser(){

        return "User Saved";
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
