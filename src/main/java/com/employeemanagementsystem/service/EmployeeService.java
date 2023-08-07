package com.employeemanagementsystem.service;

import com.employeemanagementsystem.dto.NewEmployeeRequest;
import com.employeemanagementsystem.dto.UpdateEmployeeRequest;
import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.exception.EmployeeNotFoundException;
import com.employeemanagementsystem.exception.InvalidEmployeeDataException;
import com.employeemanagementsystem.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(NewEmployeeRequest request) {
        // Perform data validation
        if (request.name() == null || request.name().isEmpty()) {
            throw new InvalidEmployeeDataException("Employee name cannot be empty.");
        }

        if (request.phoneNumber() == null || request.phoneNumber().isEmpty()) {
            throw new InvalidEmployeeDataException("Employee phone number cannot be empty.");
        }

        Employee employee = new Employee();
        employee.setName(request.name());
        employee.setPhoneNumber(request.phoneNumber());
        employee.setDepartment(request.department());
        employee.setWorkingStatus(request.isWorkingStatus());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Integer id, UpdateEmployeeRequest request) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
        }

        Employee existingEmployee = optionalEmployee.get();
        existingEmployee.setName(request.name());
        existingEmployee.setPhoneNumber(request.phoneNumber());
        existingEmployee.setDepartment(request.department());
        existingEmployee.setWorkingStatus(request.isWorkingStatus());

        return existingEmployee;
    }
}