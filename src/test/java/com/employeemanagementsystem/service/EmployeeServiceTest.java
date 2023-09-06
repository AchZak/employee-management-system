package com.employeemanagementsystem.service;

import com.employeemanagementsystem.dto.NewEmployeeRequest;
import com.employeemanagementsystem.dto.UpdateEmployeeRequest;
import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService underTest;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void itShouldGetAllEmployees() {
        // Given
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "123-456-7890", "HR", true));
        employees.add(new Employee(2, "Jane Smith", "987-654-3210", "IT", true));

        when(employeeRepository.findAll()).thenReturn(employees);

        // When
        List<Employee> result = underTest.getAllEmployees();

        // Then
        assertNotNull(result);
        assertEquals(employees.size(), result.size());
        assertEquals(employees, result);

        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void itShouldAddEmployee() {
        // Given
        NewEmployeeRequest request = new NewEmployeeRequest("Alice Johnson", "555-123-4567", "Finance", true);
        Employee savedEmployee = new Employee(3, "Alice Johnson", "555-123-4567", "Finance", true);

        when(employeeRepository.save(any(Employee.class))).thenReturn(savedEmployee);

        // When
        Employee result = underTest.addEmployee(request);

        // Then
        assertNotNull(result);
        assertEquals(savedEmployee, result);

        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void itShouldDeleteEmployee() {
        // Given
        Integer employeeId = 1;

        // When
        underTest.deleteEmployee(employeeId);

        // Then
        verify(employeeRepository, times(1)).deleteById(employeeId);
    }

    @Test
    void itShouldUpdateEmployee() {
        // Given
        Integer employeeId = 1;
        Employee existingEmployee = new Employee(employeeId, "Old Name", "Old Phone", "Old Dept", false);
        Optional<Employee> optionalEmployee = Optional.of(existingEmployee);
        UpdateEmployeeRequest request = new UpdateEmployeeRequest("John Doe", "123-456-7890", "HR", true);

        when(employeeRepository.findById(employeeId)).thenReturn(optionalEmployee);

        // When
        Employee result = underTest.updateEmployee(employeeId, request);

        // Then
        assertNotNull(result);
        assertEquals(existingEmployee.getId(), result.getId());
        assertEquals(request.name(), result.getName());
        assertEquals(request.phoneNumber(), result.getPhoneNumber());
        assertEquals(request.department(), result.getDepartment());
        assertEquals(request.isCurrentlyWorking(), result.isCurrentlyWorking());

        // Verify that save was called with the updated employee
        verify(employeeRepository, times(1)).save(result);
    }
}