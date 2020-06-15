package com.shop.shoporder.mapper;

import com.shop.shoporder.bean.Employee;
import org.apache.ibatis.annotations.Options;

//@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insertEmp(Employee employee);
}
