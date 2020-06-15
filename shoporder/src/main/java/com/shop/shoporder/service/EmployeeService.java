package com.shop.shoporder.service;

import com.shop.shoporder.bean.Employee;
import com.shop.shoporder.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    //该注解开启该方法缓存
    @Cacheable(cacheNames = "emp", condition = "#id>0", unless = "#result==null", sync = false)
    public Employee getEmpById(Integer id){
        System.out.println("查询" + id + "号员工");
        Employee emp = employeeMapper.getEmpById(id);
        System.out.println("查询部门" + emp.getLastName());

        return emp;
    }

    public void insertEmployee(Employee employee){
        System.out.println("插入新员工" + employee.toString());
        employeeMapper.insertEmp(employee);
    }

}
