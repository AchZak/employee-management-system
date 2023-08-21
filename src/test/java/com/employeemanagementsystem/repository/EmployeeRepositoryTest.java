package com.employeemanagementsystem.repository;

import com.employeemanagementsystem.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository underTest;

    @Test
    public void ItShouldSaveEmployeeToDatabase() {
        // Given
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setPhoneNumber("123-456-7890");
        employee.setDepartment("HR");
        employee.setWorkingStatus(true);

        // When
        underTest.save(employee);

        // Then
        Optional<Employee> optionalEmployee = underTest.findById(employee.getId());
        assertThat(optionalEmployee).isPresent();
    }
}