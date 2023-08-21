package com.employeemanagementsystem.controller;

import com.employeemanagementsystem.dto.NewEmployeeRequest;
import com.employeemanagementsystem.dto.UpdateEmployeeRequest;
import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.service.EmployeeService;
import com.employeemanagementsystem.repository.EmployeeRepository; // Import the EmployeeRepository
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController underTest;

    @Mock
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository; // Inject the EmployeeRepository

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    void itShouldGetAllEmployees() {
        // Given
        List<Employee> employees = List.of(
                new Employee(1, "John Doe", "123-456-7890", "HR", true),
                new Employee(2, "Jane Smith", "987-654-3210", "IT", true)
        );

        // Mock service to return employees
        when(employeeService.getAllEmployees()).thenReturn(employees);

        // When
        ResponseEntity<List<Employee>> response = underTest.getAllEmployees();

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verify that the service method was called
        verify(employeeService, times(1)).getAllEmployees();
    }

    @Test
    void itShouldAddEmployee() {
        // Given
        NewEmployeeRequest newEmployeeRequest = new NewEmployeeRequest("Alice Johnson", "555-123-4567", "Finance", true);

        Employee newEmployee = new Employee(3, "Alice Johnson", "555-123-4567", "Finance", true);

        // Mock service to save the new employee
        when(employeeService.addEmployee(any(NewEmployeeRequest.class))).thenReturn(newEmployee);

        // When
        ResponseEntity<Employee> responseEntity = underTest.addEmployee(newEmployeeRequest);

        // Then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(newEmployee, responseEntity.getBody());
        verify(employeeService).addEmployee(any(NewEmployeeRequest.class));
    }

    @Test
    void itShouldDeleteEmployee() {
        // Given
        Integer employeeId = 1; // Replace with the actual ID of the employee you want to delete

        // Mock the service's deleteEmployee method
        doNothing().when(employeeService).deleteEmployee(employeeId);

        // When
        ResponseEntity<Void> response = underTest.deleteEmployee(employeeId);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

        // Verify that the service's deleteEmployee method was called
        verify(employeeService, times(1)).deleteEmployee(employeeId);
    }

    @Test
    void itShouldUpdateEmployee() {
        // Given
        Integer employeeId = 1; // Replace with the actual ID of the employee you want to update
        UpdateEmployeeRequest request = new UpdateEmployeeRequest("John Doe", "123-456-7890", "HR", true); // Provide the required data

        // Mock the service's updateEmployee method
        Employee updatedEmployee = new Employee(); // Create a mock updated employee object
        when(employeeService.updateEmployee(employeeId, request)).thenReturn(updatedEmployee);

        // When
        ResponseEntity<Employee> response = underTest.updateEmployee(employeeId, request);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedEmployee, response.getBody());

        // Verify that the service's updateEmployee method was called
        verify(employeeService, times(1)).updateEmployee(employeeId, request);
    }
}