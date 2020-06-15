package com.shop.shoporder.mapper;

import com.shop.shoporder.bean.Department;
import org.apache.ibatis.annotations.*;

//@Mapper
public interface DepartmentMapper {

//    @Select("SELECT * FROM department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("DELETE FROM department where id=#{id}")
    public int deleteDeptById(Integer id);

//    @Options(useGeneratedKeys = true,keyProperty = "id")
//    @Insert("INSERT INTO department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("UPDATE department SET department_name=#{departmentName} WHERE id={#id}")
    public int updateDept(Department department);
}
