package com.heroic.service.impl;

import com.heroic.mapper.EmployeeMapper;
import com.heroic.pojo.Employee;
import com.heroic.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Bao
 * @Description:
 * @Date 2018/11/26
 */
@Service
@CacheConfig(cacheNames="emp")//抽取缓存的公共配置
public class EmployeeServiceImpl  implements EmployeeService{
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    @Cacheable(value = {"emp"} ,key = "#id")
    public Employee selectByPrimaryKey(Integer id) {

        return employeeMapper.selectByPrimaryKey(id);
    }
}
