package com.chaolong.cache.controller;

import com.chaolong.cache.bean.Employee;
import com.chaolong.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Longchao on 2018/5/12
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        Employee emp = employeeService.getEmp(id);
        return emp;
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee) {
        System.out.println("updateEmp:" + employee);
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }

    @GetMapping("/deleteEmp")
    public String deleteEmp(Integer id) {
        employeeService.deleteEmp(id);
        return "sucdess";
    }


}
