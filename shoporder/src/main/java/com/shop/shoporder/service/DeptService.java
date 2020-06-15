package com.shop.shoporder.service;

import com.shop.shoporder.bean.Department;
import com.shop.shoporder.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    //该注解开启该方法缓存
    @Cacheable(cacheNames = "dept", condition = "#id>0", unless = "#result==null", sync = false)
    public Department getDeptById(Integer id){
        System.out.println("查询部门" + id);
        Department department = departmentMapper.getDeptById(id);
        System.out.println("查询部门" + department.getDepartmentName());

        return department;
    }

    @Cacheable
    public void insertDept(Department department){//insertEmployee
        System.out.println("插入部门" + department.toString());
        departmentMapper.insertDept(department);
    }

}
