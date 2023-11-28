package com.example.siverbellschool.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Entity
@Getter
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Major {
    @GeneratedValue
    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture essentialLecture;

    @Builder Major(String name, Lecture lecture) {
        Assert.hasLength(name, "Name must not be empty");
        this.name = name;
        Assert.notNull(lecture, "Essential Lecture must not be null");
        this.essentialLecture = lecture;
    }
}
