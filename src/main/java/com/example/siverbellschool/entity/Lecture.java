package com.example.siverbellschool.entity;

import com.example.siverbellschool.enumerate.LectureType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Getter
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lecture {
    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private LectureType lectureType;

    @Builder
    protected Lecture(String name, LectureType lectureType) {
        Assert.hasLength("name", "Name must not be empty");
        this.name = name;
        this.lectureType = lectureType;
    }
}
