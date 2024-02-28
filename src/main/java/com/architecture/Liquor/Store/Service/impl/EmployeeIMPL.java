package com.architecture.Liquor.Store.Service.impl;

import com.architecture.Liquor.Store.Dto.EmployeeDTO;
import com.architecture.Liquor.Store.Entity.Employee;
import com.architecture.Liquor.Store.Repo.EmployeeRepo;
import com.architecture.Liquor.Store.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EmployeeIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
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
        employeeRepo.save(employee);
        return employee.getEmployeename();



    }
}
