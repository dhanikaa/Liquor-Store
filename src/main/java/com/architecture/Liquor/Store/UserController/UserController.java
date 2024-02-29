package com.architecture.Liquor.Store.UserController;


import com.architecture.Liquor.Store.Service.EmployeeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.Service.EmployeeService;
import com.example.RegisterLogin.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.RegisterLogin.Dto.EmployeeDTO;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")

public class UserController {



    @Autowired
    private EmployeeService employeeService;


    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }
}
