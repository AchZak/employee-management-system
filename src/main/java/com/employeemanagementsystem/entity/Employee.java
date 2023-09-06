package com.employeemanagementsystem.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Employee {
    @Id
    @SequenceGenerator(name = "employee_id_sequence", sequenceName = "employee_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_sequence")
    private Integer id;

    //@Column(name = "name")
    private String name;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    //@Column(name = "department")
    private String department;
    @Column(name = "isCurrentlyWorking")
    private boolean isCurrentlyWorking;

    public Employee(Integer id, String name, String phoneNumber, String department, boolean isCurrentlyWorking) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.id = id;
        this.isCurrentlyWorking = isCurrentlyWorking;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isCurrentlyWorking() {
        return isCurrentlyWorking;
    }

    public void setCurrentlyWorking(boolean currentlyWorking) {
        isCurrentlyWorking = currentlyWorking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return isCurrentlyWorking == employee.isCurrentlyWorking && Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, department, isCurrentlyWorking);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", department='" + department + '\'' +
                ", isCurrentlyWorking=" + isCurrentlyWorking +
                '}';
    }
}
