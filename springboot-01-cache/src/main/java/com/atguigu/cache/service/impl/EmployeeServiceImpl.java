package com.atguigu.cache.service.impl;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import com.atguigu.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    @Cacheable(value = "emp")
    public Employee getEmployee(Integer id) {
        System.out.println("查询的ID为： " + id);
        return employeeMapper.getEmpById(id);
    }

    @Override
    @CachePut(value = "emp",key = "#result.id")
    public Employee updateEmployee(Employee employee) {
        employeeMapper.updateEmp(employee);
        return employee;
    }
}
