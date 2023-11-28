package com.example.siverbellschool.service;

import com.example.siverbellschool.dto.AddStudentRequest;
import com.example.siverbellschool.entity.Major;
import com.example.siverbellschool.entity.Student;
import com.example.siverbellschool.repository.MajorRepository;
import com.example.siverbellschool.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final MajorRepository majorRepository;

    public List<Student> getStudents() { return studentRepository.findAll(); }

    public void addStudent(AddStudentRequest addStudentRequest) {
        Major major = majorRepository.findById(addStudentRequest.getMajorId()).orElseThrow();
        Student student = Student.builder().name(addStudentRequest.getStudentName()).studentId(addStudentRequest.getStudentId()).major(major).build();
        studentRepository.save(student);
    }
}
