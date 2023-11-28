package com.example.siverbellschool.service;

import com.example.siverbellschool.dto.AddMajorRequest;
import com.example.siverbellschool.entity.Lecture;
import com.example.siverbellschool.entity.Major;
import com.example.siverbellschool.repository.LectureRepository;
import com.example.siverbellschool.repository.MajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MajorService {

    private final MajorRepository majorRepository;
    private final LectureRepository lectureRepository;

    public List<Major> getMajors() { return majorRepository.findAll(); }

    public void addMajor(AddMajorRequest addMajorRequest) {
        Lecture essentialLecture = lectureRepository.findById(addMajorRequest.getEssentialLectureId()).orElseThrow();
        Major major = Major.builder().name(addMajorRequest.getMajorName()).lecture(essentialLecture).build();
        majorRepository.save(major);
    }
}
