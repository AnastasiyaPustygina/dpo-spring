package com.polytech.courses.dpo_spring.dto;

import lombok.Data;

@Data
public class CourseEnrollmentRequest {
    private final String fullName;
    private final String email;
    private final String phone;
    private final String comment;
}