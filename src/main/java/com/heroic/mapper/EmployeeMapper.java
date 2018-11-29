package com.heroic.mapper;

import com.heroic.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface EmployeeMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(Employee record);


    Employee selectByPrimaryKey(Integer id);


    List<Employee> selectAll();


    int updateByPrimaryKey(Employee record);
}