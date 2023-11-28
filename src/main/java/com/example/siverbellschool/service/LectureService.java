package com.example.siverbellschool.service;

import com.example.siverbellschool.dto.AddLectureRequest;
import com.example.siverbellschool.entity.Lecture;
import com.example.siverbellschool.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LectureService {

    private final LectureRepository lectureRepository;
    public List<Lecture> getLectures() { return lectureRepository.findAll(); }

    public void addLecture(AddLectureRequest addLectureRequest) {lectureRepository.save(addLectureRequest.toEntity());}
}
