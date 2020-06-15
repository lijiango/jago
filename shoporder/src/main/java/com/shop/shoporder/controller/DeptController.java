package com.shop.shoporder.controller;

import com.shop.shoporder.bean.Department;
import com.shop.shoporder.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id)
    {
        return deptService.getDeptById(id);
    }

    @PostMapping("/dept/")
    public Department insertDept(Department department){
        deptService.insertDept(department);
         return department;
    }
}
