package com.example.company_intranet_portal.controller;

import com.example.company_intranet_portal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("employees",
                employeeService.getEmployees());

        return "index";
    }

    @GetMapping("/holidays")
    public String holidays() {
        return "holidays";
    }

    @GetMapping("/hr-policies")
    public String hrPolicies() {
        return "hr-policies";
    }

}