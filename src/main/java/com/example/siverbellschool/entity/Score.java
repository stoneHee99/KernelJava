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
public class Score {
    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    private int score;

    @Builder
    protected Score(Student student, Lecture lecture, int score) {
        Assert.notNull(student, "Student must not be null");
        this.student = student;
        Assert.notNull(lecture, "Lecture must not be null");
        this.lecture = lecture;
        this.score = score;
    }
}
