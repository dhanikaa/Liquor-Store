package com.architecture.Liquor.Store.Service.impl;

import com.architecture.Liquor.Store.Repo.UserRepo;
import com.architecture.Liquor.Store.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserIMPL implements EmployeeService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {


        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),
                this.passwordEncoder.encode(employeeDTO.getPassword())
        );
        userRepo.save(employee);
        return employee.getEmployeename();



    }
}
