package com.example.siverbellschool.dto;

import lombok.Data;

@Data
public class AddMajorRequest {
    private String majorName;
    private Long essentialLectureId;
}
