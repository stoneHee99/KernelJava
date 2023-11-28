package com.example.siverbellschool.controller;

import com.example.siverbellschool.dto.AddMajorRequest;
import com.example.siverbellschool.service.LectureService;
import com.example.siverbellschool.service.MajorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/major")
public class MajorContoller {

    private final MajorService majorService;
    private final LectureService lectureService;

    @GetMapping("/list")
    public String showMajorList(Model model) {
        model.addAttribute("majors", majorService.getMajors());
        return "major/list";
    }

    @GetMapping("/add")
    public String showMajorAddForm(Model model) {
        model.addAttribute("lectures", lectureService.getLectures());
        return "major/add";
    }

    @PostMapping("/add")
    public String addMajor(AddMajorRequest addMajorRequest) {
        majorService.addMajor(addMajorRequest);
        return "redirect:/major/list";
    }
}
