package com.example.siverbellschool.dto;

import lombok.Data;

@Data
public class ScoreBoard {
    private String studentName;
    private String studentId;
    private String essentialLectureName;
    private int score;
    private String grade;
}
