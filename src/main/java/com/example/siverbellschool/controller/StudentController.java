package com.example.siverbellschool.controller;

import com.example.siverbellschool.dto.AddStudentRequest;
import com.example.siverbellschool.service.MajorService;
import com.example.siverbellschool.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final MajorService majorService;

    @GetMapping("/list")
    public String showStudentList(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "student/list";
    }

    @GetMapping("/add")
    public String showStudentAddForm(Model model) {
        model.addAttribute("majors", majorService.getMajors());
        return "student/add";
    }

    @PostMapping("/add")
    public String addStudent(AddStudentRequest addStudentRequest) {
        studentService.addStudent(addStudentRequest);
        return "redirect:/student/list";
    }
}
