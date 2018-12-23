package com.atguigu.cache.service;


import com.atguigu.cache.bean.Employee;

public interface EmployeeService {

    Employee getEmployee(Integer id);

    Employee updateEmployee(Employee employee);
}
