package com.employeemanagementsystem.entity;

import com.employeemanagementsystem.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeTest {
    private Employee underTest;

    @BeforeEach
    public void setUp() {
        // Initialize the Employee object before each test
        underTest = new Employee(1, "John Doe", "123-456-7890", "HR", true);
    }

    @Test
    public void testEmployeeConstructorAndGetters() {
        // Test the constructor and getters
        assertEquals(1, underTest.getId());
        assertEquals("John Doe", underTest.getName());
        assertEquals("123-456-7890", underTest.getPhoneNumber());
        assertEquals("HR", underTest.getDepartment());
        assertTrue(underTest.isWorkingStatus());
    }

    @Test
    public void testEmployeeSetters() {
        // Test the setters
        underTest.setId(2);
        underTest.setName("Jane Smith");
        underTest.setPhoneNumber("987-654-3210");
        underTest.setDepartment("IT");
        underTest.setWorkingStatus(false);

        assertEquals(2, underTest.getId());
        assertEquals("Jane Smith", underTest.getName());
        assertEquals("987-654-3210", underTest.getPhoneNumber());
        assertEquals("IT", underTest.getDepartment());
        assertFalse(underTest.isWorkingStatus());
    }

    @Test
    public void testEqualsAndHashCode() {
        // Test equals and hashCode methods
        Employee sameEmployee = new Employee(1, "John Doe", "123-456-7890", "HR", true);
        Employee differentEmployee = new Employee(2, "Jane Smith", "987-654-3210", "IT", false);

        assertEquals(underTest, sameEmployee);
        assertNotEquals(underTest, differentEmployee);
        assertEquals(underTest.hashCode(), sameEmployee.hashCode());
        assertNotEquals(underTest.hashCode(), differentEmployee.hashCode());
    }

    @Test
    public void testToString() {
        // Test the toString method
        String expectedToString = "Employee{id=1, name='John Doe', phoneNumber='123-456-7890', department='HR', isWorkingStatus=true}";
        assertEquals(expectedToString, underTest.toString());
    }
}