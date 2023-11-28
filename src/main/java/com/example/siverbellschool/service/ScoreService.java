package com.example.siverbellschool.service;

import com.example.siverbellschool.dto.ApplyRequest;
import com.example.siverbellschool.dto.ScoreBoard;
import com.example.siverbellschool.entity.Lecture;
import com.example.siverbellschool.entity.Score;
import com.example.siverbellschool.entity.Student;
import com.example.siverbellschool.enumerate.LectureType;
import com.example.siverbellschool.repository.LectureRepository;
import com.example.siverbellschool.repository.ScoreRepository;
import com.example.siverbellschool.repository.StudentRepository;
import com.example.siverbellschool.utils.BasicEvaluation;
import com.example.siverbellschool.utils.GradeEvaluation;
import com.example.siverbellschool.utils.MajorEvaluation;
import com.example.siverbellschool.utils.PassFailEvaluation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;
    private final LectureRepository lectureRepository;
    private final StudentRepository studentRepository;

    public void applyLecture(ApplyRequest applyRequest) {
        Lecture lecture = lectureRepository.findById(applyRequest.getLectureId()).orElseThrow();
        Student student = studentRepository.findById(applyRequest.getStudentId()).orElseThrow();
        Score score = Score.builder().lecture(lecture).student(student).score(generateScore()).build();
        scoreRepository.save(score);
    }

    private static int generateScore() {
        Random random = new Random();
        return random.nextInt(101);
    }

    public List<Lecture> getLecturesWithScore() {
        return scoreRepository.findLecturesWithScores();
    }

    public List<ScoreBoard> getScore(Long lectureId) {
        Lecture lecture = lectureRepository.findById(lectureId).orElseThrow();
        List<Score> scores = scoreRepository.findAllByLecture(lecture);

        return scores.stream().map(score -> {
            ScoreBoard board = new ScoreBoard();
            board.setStudentName(score.getStudent().getName());
            board.setStudentId(score.getStudent().getStudentId());
            board.setEssentialLectureName(score.getStudent().getMajor().getEssentialLecture().getName());
            board.setScore(score.getScore());
            board.setGrade(calculateGrade(score, lecture));
            return board;
        }).collect(Collectors.toList());
    }

    private String calculateGrade(Score score, Lecture lecture) {
        Student student = score.getStudent();
        LectureType lectureType = lecture.getLectureType();

        GradeEvaluation evaluation;

        if (lectureType == LectureType.SCORE && student.getMajor().getEssentialLecture().equals(lecture)) {
            evaluation = new MajorEvaluation();
        } else {
            evaluation = getEvaluation(lectureType);
        }

        return evaluation.getGrade(score.getScore());
    }

    private GradeEvaluation getEvaluation(LectureType type) {
        if(type == LectureType.SCORE) return new BasicEvaluation();
        if(type == LectureType.PASS_FAIL) return new PassFailEvaluation();
        throw new IllegalArgumentException();
    }
}
