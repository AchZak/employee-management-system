package com.employeemanagementsystem.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Employee {
    @Id
    private Integer id;
    private String name;
    private String phoneNumber;
    private String department;
    private boolean workingStatus;

    public Employee(Integer id, String name, String phoneNumber, String department, boolean workingStatus) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.id = id;
        this.workingStatus = workingStatus;
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

    public boolean isWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(boolean workingStatus) {
        this.workingStatus = workingStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return workingStatus == employee.workingStatus && Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, department, workingStatus);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", department='" + department + '\'' +
                ", workingStatus=" + workingStatus +
                '}';
    }
}
