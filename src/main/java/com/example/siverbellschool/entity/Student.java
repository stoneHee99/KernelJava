package com.example.siverbellschool.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student {
    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private String studentId;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    @Builder
    protected Student(String name, String studentId, Major major) {
        Assert.hasLength(name, "Name must not be empty");
        this.name = name;
        Assert.hasLength(studentId, "Student Id must not be empty");
        this.studentId = studentId;
        Assert.notNull(major, "Major must not be null");
        this.major = major;
    }
}
