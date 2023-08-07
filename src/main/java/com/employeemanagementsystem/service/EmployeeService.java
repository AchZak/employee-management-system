package com.employeemanagementsystem.service;

import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> getAlLEmployees()
    {
        return employeeRepository.findAll();
    }

    public void addEmployee(){
        Employee employee = new Employee();


    }

    public void deleteEmployee(Employee employee){
        this.employeeRepository.delete(employee);
    }

    public void updateEmployee(){
    }

}
