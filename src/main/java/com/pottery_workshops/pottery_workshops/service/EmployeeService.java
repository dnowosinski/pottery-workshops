package com.pottery_workshops.pottery_workshops.service;

import com.pottery_workshops.pottery_workshops.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeService employeeService;

    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    public Employee save(Employee employee) {
        return employeeService.save(employee);
    }
}