package com.shop.shoporder.controller;

import com.shop.shoporder.bean.Employee;
import com.shop.shoporder.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){

        return employeeService.getEmpById(id);
    }

    @PostMapping("/employee/")
    public Employee insertEmp(Employee employee){
        employeeService.insertEmployee(employee);
        return employee;
    }

}
