package com.example.siverbellschool.repository;

import com.example.siverbellschool.entity.Lecture;
import com.example.siverbellschool.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

    @Query("SELECT DISTINCT s.lecture FROM Score s")
    List<Lecture> findLecturesWithScores();

    List<Score> findAllByLecture(Lecture lecture);
}
