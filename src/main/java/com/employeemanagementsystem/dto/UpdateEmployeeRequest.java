package com.employeemanagementsystem.dto;

public record UpdateEmployeeRequest(String name, String phoneNumber, String department, boolean isWorkingStatus) {
}
