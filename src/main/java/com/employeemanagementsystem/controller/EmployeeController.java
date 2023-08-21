package com.employeemanagementsystem.controller;


import com.employeemanagementsystem.dto.NewEmployeeRequest;
import com.employeemanagementsystem.dto.UpdateEmployeeRequest;
import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody NewEmployeeRequest request) {
        Employee createdEmployee = employeeService.addEmployee(request);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody UpdateEmployeeRequest request) {
        Employee updatedEmployee = employeeService.updateEmployee(id, request);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
}
