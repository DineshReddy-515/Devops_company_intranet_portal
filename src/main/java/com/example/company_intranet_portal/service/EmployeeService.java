package com.example.company_intranet_portal.service;

import com.example.company_intranet_portal.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> getEmployees() {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Dinesh", "IT", "Software Engineer"));
        employees.add(new Employee(102, "Rahul", "HR", "HR Executive"));
        employees.add(new Employee(103, "Priya", "Finance", "Accountant"));

        return employees;
    }

}