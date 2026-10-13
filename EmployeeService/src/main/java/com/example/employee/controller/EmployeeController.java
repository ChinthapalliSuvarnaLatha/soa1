package com.example.employee.controller;

import org.springframework.web.bind.annotation.*;

import com.example.employee.model.Employee;

@RestController
public class EmployeeController {

    @PostMapping("/companies/{companyId}/employees")
    public String addEmployee(@PathVariable int companyId,
                              @RequestBody Employee employee) {

        return "Employee Added Successfully\n"
                + "Company ID : " + companyId
                + "\nEmployee ID : " + employee.getEmployeeId()
                + "\nEmployee Name : " + employee.getEmployeeName()
                + "\nDepartment : " + employee.getDepartment()
                + "\nSalary : " + employee.getSalary();
    }
}
