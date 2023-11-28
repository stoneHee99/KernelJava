package com.example.siverbellschool.utils;

public class PassFailEvaluation implements GradeEvaluation{

    @Override
    public String getGrade(int point) {
        if(point >= 70 && point <= 100) return "P";
        return "F";
    }
}
