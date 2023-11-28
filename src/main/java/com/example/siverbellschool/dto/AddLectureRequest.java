package com.example.siverbellschool.dto;

import com.example.siverbellschool.entity.Lecture;
import com.example.siverbellschool.enumerate.LectureType;
import lombok.Data;

@Data
public class AddLectureRequest {
    private String lectureName;
    private LectureType lectureType;

    public Lecture toEntity() {
        return Lecture.builder().name(lectureName).lectureType(lectureType).build();
    }
}
