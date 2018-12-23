package com.atguigu.cache.controller;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private static final Logger logger= LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/get/{id}")
    public Employee getEmp(@PathVariable Integer id) {
        logger.debug("id为 ： " +id);
        return employeeService.getEmployee(id);
    }

    @GetMapping(value = "/emp")
    public Employee updateEmp(Employee employee) {
        return employeeService.updateEmployee(employee);
    }

}
