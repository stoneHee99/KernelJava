package com.example.siverbellschool.dto;

import lombok.Data;

@Data
public class AddStudentRequest {
    private String studentName;
    private String studentId;
    private Long majorId;
}
