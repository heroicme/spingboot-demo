package com.heroic.controller;

import com.heroic.pojo.Employee;
import com.heroic.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bao
 * @Description:
 * @Date 2018/11/26
 */
@RestController
public class DepartmentController {

@Autowired
private EmployeeService employeeService;

    @RequestMapping("/emp/{id}")
    public Employee getEmp(@PathVariable Integer id){

      return   employeeService.selectByPrimaryKey(id);

    }


}
